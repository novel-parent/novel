package com.yc.novelclient.service.impl;


import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.NovelQueue;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yc.novelclient.service.VisitorNovelService;
import util.NovelClientUtil;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
@Service
public class VisitorNovelServiceImpl implements VisitorNovelService {


    @Autowired
    private VisitorNovelService visitorNovelService;

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid) throws ReadNovelChapterContextException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelChapterUrl = introductionNovel.getUrl()+cid+".html";
        ReadNovel chapterContext = null;
        try {

//            NovelThriftClient client = new NovelThriftClient();

            NovelThriftClient thriftClient = NovelQueue.novelThriftClientQueue.take();

            chapterContext = thriftClient.getNovelChapterContextByChapterUrl(novelChapterUrl);

            NovelQueue.novelThriftClientQueue.add(thriftClient);
        } catch (TException e) {

            throw new ReadNovelChapterContextException
                    ("VisitorNovelServiceImpl.getNovelChapterContext(long, long) 游客获得小说章节内容出错");
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {
                chapterContext = NovelClientUtil.getNovelChapterContext(novelChapterUrl);
            } catch (TException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }


    @Cacheable(cacheNames = "chapters" ,key = "#nid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public String getIntroductionNovelChapters(long nid) throws IntroductionNovelChaptersException {

        System.out.println("游客访问:  "+nid+"  小说章节");
        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelUrl = introductionNovel.getUrl();

        String chapters = null;
        try {
//            NovelThriftClient client = new NovelThriftClient();
            NovelThriftClient thriftClient = NovelQueue.novelThriftClientQueue.take();

            System.out.println(NovelQueue.novelThriftClientQueue.size());
            chapters = thriftClient.getNovelChapterListByNovelUrl(novelUrl);

            NovelQueue.novelThriftClientQueue.add(thriftClient);
            System.out.println(NovelQueue.novelThriftClientQueue.size());
        } catch (TException e) {

            throw new IntroductionNovelChaptersException
                    ("VisitorNovelServiceImpl.getIntroductionNovelChapters  游客获得章节列表出错");
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {


                chapters = NovelClientUtil.getNovelChapters(novelUrl);

            } catch (TTransportException e1) {
                e1.printStackTrace();
            } catch (TException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return chapters;
    }
}
