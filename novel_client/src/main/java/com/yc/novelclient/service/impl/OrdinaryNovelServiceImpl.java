package com.yc.novelclient.service.impl;

import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.novelclient.service.OrdinaryNovelService;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.NovelQueue;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import util.NovelClientUtil;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
@Service
public class OrdinaryNovelServiceImpl implements OrdinaryNovelService {

    @Autowired
    private NovelMapper novelMapper;


    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) throws TException, InterruptedException, ReadNovelChapterContextException {

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
                    ("com.yc.novelclient.service.impl.OrdinaryNovelServiceImpl.getNovelChapterContext 用户获得小说章节内容出错");
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {
                chapterContext = NovelClientUtil.getNovelChapterContext(novelChapterUrl);
            } catch (TException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return chapterContext;
    }

    @Cacheable(cacheNames = "chapters" ,key = "#nid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public String getIntroductionNovelChapters(long nid, String uid) throws TException, IntroductionNovelChaptersException {

        System.out.println("普通用户访问:  "+nid+"  小说章节");
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
                    ("com.yc.novelclient.service.impl.OrdinaryNovelServiceImpl.getNovelChapterContext  用户获得章节列表出错");
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
