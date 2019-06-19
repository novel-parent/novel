package com.yc.novelclient.service.impl;


import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.NovelQueue;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yc.novelclient.service.VisitorNovelService;

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
//            client.getTransport().close();
        } catch (TException e) {

            throw new ReadNovelChapterContextException
                    ("VisitorNovelServiceImpl.getNovelChapterContext(long, long) 游客获得小说章节内容出错");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return chapterContext;
    }


    @Cacheable(cacheNames = "chapters" ,key = "#nid")
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
//            chapters = client.getNovelChapterListByNovelUrl(novelUrl);
//            client.getTransport().close();
        } catch (TException e) {

            throw new IntroductionNovelChaptersException
                    ("VisitorNovelServiceImpl.getIntroductionNovelChapters  游客获得章节列表出错");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        return chapters;
    }
}
