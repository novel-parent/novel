package com.yc.novelclient.service.impl;

import com.yc.bean.IntroductionDiv;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadDiv;
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
import org.springframework.stereotype.Service;
import com.yc.novelclient.util.NovelClientUtil;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
@Service
public class OrdinaryNovelServiceImpl implements OrdinaryNovelService {

    @Autowired
    private NovelMapper novelMapper;


    @Cacheable(cacheNames = "chapterContext" , key = "#cid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public ReadDiv getNovelChapterContext(long nid, long cid, String uid) throws TException, InterruptedException, ReadNovelChapterContextException {

        ReadDiv readDiv = null;
        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelChapterUrl = introductionNovel.getUrl()+cid+".html";
        ReadNovel chapterContext = null;
        try {

            NovelThriftClient thriftClient = NovelQueue.novelThriftClientQueue.take();

            chapterContext = thriftClient.getNovelChapterContextByChapterUrl(novelChapterUrl);

            readDiv = new ReadDiv();

            readDiv.setIntroductionNovel(introductionNovel);

            readDiv.setReadNovel(chapterContext);

            NovelQueue.novelThriftClientQueue.add(thriftClient);
        } catch (TException e) {

            throw new ReadNovelChapterContextException
                    ("com.yc.novelclient.service.impl.OrdinaryNovelServiceImpl.getNovelChapterContext 用户获得小说章节内容出错");
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {
                chapterContext = NovelClientUtil.getNovelChapterContext(novelChapterUrl);
                readDiv = new ReadDiv();

                readDiv.setIntroductionNovel(introductionNovel);

                readDiv.setReadNovel(chapterContext);
            } catch (TException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return readDiv;
    }

    @Cacheable(cacheNames = "chapters" ,key = "#nid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public IntroductionDiv getIntroductionNovelChapters(long nid, String uid) throws TException, IntroductionNovelChaptersException {

        IntroductionDiv introductionDiv = null;

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelUrl = introductionNovel.getUrl();

        String chapters = null;
        try {
            NovelThriftClient thriftClient = NovelQueue.novelThriftClientQueue.take();

            chapters = thriftClient.getNovelChapterListByNovelUrl(novelUrl);

            introductionDiv = new IntroductionDiv();

            introductionDiv.setIntroductionNovel(introductionNovel);

            introductionDiv.setNovelChapters(chapters);

            NovelQueue.novelThriftClientQueue.add(thriftClient);
        } catch (TException e) {

            throw new IntroductionNovelChaptersException
                    ("com.yc.novelclient.service.impl.OrdinaryNovelServiceImpl.getNovelChapterContext  用户获得章节列表出错");
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {
                chapters = NovelClientUtil.getNovelChapters(novelUrl);
                introductionDiv = new IntroductionDiv();

                introductionDiv.setIntroductionNovel(introductionNovel);

                introductionDiv.setNovelChapters(chapters);

            } catch (TTransportException e1) {
                e1.printStackTrace();
            } catch (TException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return introductionDiv;
    }
}
