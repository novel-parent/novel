package com.yc.novelclient.impl;


import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.thrift.IDL.NovelChapter;
import com.yc.thrift.IDL.NovelChapterContext;
import com.yc.thrift.IDL.NovelService;
import com.yc.thrift.client.UserThriftClient;
import com.yc.thrift.client.VipUserThriftClient;
import com.yc.thrift.client.VisitorThriftClient;
import com.yc.novelclient.mapper.NovelMapper;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.novelclient.service.VisitorNovelService;
import util.VisitorUtil;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
@Service
public class VisitorNovelServiceImpl implements VisitorNovelService {

    private HashMap<String,VisitorThriftClient> visitorThriftClientHashMap = VisitorUtil.visitorThriftClientHashMap;

    @Autowired
    private VisitorNovelService visitorNovelService;

    @Autowired
    private NovelMapper novelMapper;

    /**
     * 游客访问  获取小说的章节的信息
     * @param nid
     * @param cid
     * @return
     */
    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid) throws ReadNovelChapterContextException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelChapterUrl = introductionNovel.getUrl()+cid+".html";
        ReadNovel chapterContext = null;
        try {
            chapterContext = getNovelChapterContext(novelChapterUrl);
        } catch (TException e) {

            throw new ReadNovelChapterContextException
                    ("VisitorNovelServiceImpl.getNovelChapterContext(long, long) 游客获得小说章节内容出错");
        }
        return chapterContext;
    }

    /**
     * 游客  获取小说介绍页面的章节信息
     * @param nid
     * @return
     */
    @Override
    public String getIntroductionNovelChapters(long nid) throws IntroductionNovelChaptersException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelUrl = introductionNovel.getUrl();
        String chapters = null;
        try {
            chapters = getNovelChapters(novelUrl);
        } catch (TException e) {

            throw new IntroductionNovelChaptersException
                    ("VisitorNovelServiceImpl.getIntroductionNovelChapters  游客获得章节列表出错");
        }

        return chapters;
    }


    public ReadNovel getNovelChapterContext(String novelChapterUrl) throws TException {

        ReadNovel readNovel = null;
        TTransport transport = new TSocket("127.0.0.1",8899);

            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);


            NovelChapterContext novelChapterContext =
                    client.getNovelChapterContextByChapterUrl(novelChapterUrl);

            readNovel= new ReadNovel();

            readNovel.setContext(novelChapterContext.getContext());

            readNovel.setLastChapter(novelChapterContext.getLastChapter());

            readNovel.setNextChapter(novelChapterContext.getNextChapter());

            readNovel.setNovelChapterName(novelChapterContext.getNovelChapterName());

            transport.close();
        return readNovel;
    }

    public String getNovelChapters(String novelUrl) throws TException {

        TTransport transport = new TSocket("127.0.0.1",8899);
            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);

        NovelChapter novelChapterList = null;
            novelChapterList = client.getNovelChapterListByNovelUrl(novelUrl);


        String novelChaptersJson = novelChapterList.getNovelChapterJson();

            transport.close();

            return  novelChaptersJson;
    }

}
