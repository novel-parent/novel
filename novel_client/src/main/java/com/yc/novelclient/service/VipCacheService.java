package com.yc.novelclient.service;

import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadDiv;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.NovelQueue;
import org.apache.thrift.TException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.yc.novelclient.util.NovelClientUtil;

/**
 * @author LX
 * @date 2019/6/20 - 13:40
 */
@Service
public class VipCacheService {

    @Async
    @Cacheable(cacheNames = "chapterContext" , key = "#cid",cacheManager = "novelChaptersRedisCacheManager",sync = true)
    public ReadDiv getNovelChapterContext(IntroductionNovel introductionNovel,String cid, String url){

        ReadDiv readDiv = null;

        ReadNovel chapterContext = null;
        try {

            NovelThriftClient thriftClient = NovelQueue.novelThriftClientQueue.take();

            chapterContext = thriftClient.getNovelChapterContextByChapterUrl(url);

            readDiv = new ReadDiv();

            readDiv.setIntroductionNovel(introductionNovel);

            readDiv.setReadNovel(chapterContext);

            NovelQueue.novelThriftClientQueue.add(thriftClient);
        } catch (TException e) {

            try {
                throw new ReadNovelChapterContextException
                        ("com.yc.novelclient.service.impl.VipNovelServiceImpl.getNovelChapterContext vip用户获得小说章节内容出错");
            } catch (ReadNovelChapterContextException e1) {
                e1.printStackTrace();
            }
        } catch (InterruptedException e) {

            //  当 队列没了   手动创建  连接
            try {
                chapterContext = NovelClientUtil.getNovelChapterContext(url);

                readDiv = new ReadDiv();

                readDiv.setIntroductionNovel(introductionNovel);

                readDiv.setReadNovel(chapterContext);
            } catch (TException e1) {

                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        System.out.println(readDiv.getReadNovel().getNovelChapterName());
        return readDiv;
    }
}
