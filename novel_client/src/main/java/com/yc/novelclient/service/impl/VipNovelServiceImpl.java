package com.yc.novelclient.service.impl;

import com.yc.bean.IntroductionNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.thrift.client.NovelThriftClient;
import com.yc.util.NovelQueue;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.yc.novelclient.service.VipNovelService;
import util.NovelClientUtil;
import util.ThreadPollUtil;

import java.util.concurrent.ExecutorService;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
@Service
public class VipNovelServiceImpl implements VipNovelService ,Runnable{

    @Autowired
    private NovelMapper novelMapper;

    private ExecutorService executorService = ThreadPollUtil.executorService;

    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid)  {

        ReadNovel readNovel = null ;

        return readNovel;
    }


    @Cacheable(cacheNames = "chapters" ,key = "#nid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public String getIntroductionNovelChapters(long nid, String uid) throws  IntroductionNovelChaptersException {

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
                    ("com.yc.novelclient.service.impl.VipNovelServiceImpl.getIntroductionNovelChapters  vip用户获得章节列表出错");
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

    @Override
    public void run() {

    }
}
