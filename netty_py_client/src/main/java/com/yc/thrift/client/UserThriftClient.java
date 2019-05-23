package com.yc.thrift.client;

import com.yc.bean.ReadNovel;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import com.yc.thrift.IDL.NovelChapterContext;
import com.yc.thrift.IDL.NovelService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/5/14 - 1:56
 */
@Scope("prototype")
@Component
public class UserThriftClient {

    private NovelService.Client client ;

    private ReadNovel readNovel ;

    private String host ="127.0.0.1";

    private int port =8899;

    public UserThriftClient() throws TTransportException {

        TTransport transport = new TSocket(host,port);

        // 会有异常    抛出异常  告诉 上面 用户服务器开启失败 . ..

        transport.open();

        TProtocol tProtocol = new TBinaryProtocol(transport);

        this.client = new NovelService.Client(tProtocol);

        this.readNovel = new ReadNovel();
    }

    /**
     *  用户  通过 小说id  获得小说章节的信息
     * @param novelUrl
     * @return
     * @throws TException
     */
    public String  getNovelChapterListByNovelUrl(String novelUrl) throws TException {

        return client.getNovelChapterListByNovelUrl(novelUrl).getNovelChapterJson();
    }

    /**
     * 用户通过  章节 id  来获取  章节内容
     *
     * 默认是  用户第一次 获取 小说章节信息
     * @param chapterUrl
     * @throws TException
     */
    public ReadNovel getNovelChapterContextByChapterUrl(String chapterUrl) throws TException {

        NovelChapterContext novelChapterContext =
                this.client.getNovelChapterContextByChapterUrl(chapterUrl);

        this.readNovel.setContext(novelChapterContext.getContext());

        this.readNovel.setLastChapter(novelChapterContext.getLastChapter());

        this.readNovel.setNextChapter(novelChapterContext.getNextChapter());

        this.readNovel.setNovelChapterName(novelChapterContext.getNovelChapterName());

        return this.readNovel;
    }

    /**
     *   将获取到的  ReadNovel信息 赋值给  传入的ReadNovel
     *              用的 初始化的client 进行取值的
     *   此方法一般为  VIP用户 使用自己 的client 的取过一次值得时候 使用
     *
     * @param chapterUrl
     * @param readNovel
     * @throws TException
     */
    public boolean getNovelChapterContextByChapterUrl(String chapterUrl,ReadNovel readNovel) {

        NovelChapterContext novelChapterContext = null;
        try {

            novelChapterContext = this.client.getNovelChapterContextByChapterUrl(chapterUrl);

        } catch (TException e) {

            e.printStackTrace();
            return false ;
        }

        this.readNovel.setContext(novelChapterContext.getContext());

        this.readNovel.setLastChapter(novelChapterContext.getLastChapter());

        this.readNovel.setNextChapter(novelChapterContext.getNextChapter());

        return true;
    }

    public NovelService.Client getClient() {
        return client;
    }

    public void setReadNovel(ReadNovel readNovel) {
        this.readNovel = readNovel;
    }

    public ReadNovel getReadNovel() {
        return readNovel;

    }
}
