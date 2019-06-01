package com.yc.thrift.client;


import com.yc.bean.ReadNovel;
import com.yc.thrift.IDL.NovelChapterContext;
import com.yc.thrift.IDL.NovelService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * VIP 用户
 * @author LX
 * @date 2019/5/14 - 1:49
 */
@Scope("prototype")
@Component

public class VipUserThriftClient extends UserThriftClient implements Runnable{

    private NovelService.Client vipClient;

    private ReadNovel nextReadNovel;

    private String nextChapterUrl;

    private String nowUrl ;

    // vip用户  会走 另外一个 服务器 进行 数据 的交互
    private String host = "127.0.0.1";

    private int port = 8899;
    /**
     *
     * flag 为 false  代表  nextReadNovel 里面有值
     *
     * 用户再 进行第二请求的时候 可以直接 从nextReadNovel 取小说信息
     *
     */
    private boolean flag ;


    /**
     * vip 用户一登录  开启 另外一个 客户端  进行 获取下一个章节的信息
     * @throws TTransportException
     */
    public VipUserThriftClient() throws TTransportException {

        super();

//        TTransport transport = new TSocket(host,port);
//
//        // 会有异常    抛出异常  告诉 上面 用户服务器开启失败 . ..
//
//        transport.open();
//
//        TProtocol tProtocol = new TBinaryProtocol(transport);
//
//        this.vipClient = new NovelService.Client(tProtocol);
//
//        System.out.println("vip client  初始化成功  ");

        this.nextReadNovel = new ReadNovel();

        this.flag = false;
    }

    /**
     * 传入 一个 ReadNovel
     * 将获取的到NovelChapter 信息存入在这个里面
     * @param nextChapterUrl
     * @throws TException
     */
    public void getNextNovelChapterContextByChapterUrl(String nextChapterUrl) throws TException {

//      每一次线程 缓存下一章节的时候 总会吧 当前的章节回写给 父类的 readNovel
//        super.setReadNovel(this.nextReadNovel);

        NovelChapterContext novelChapterContext =
                super.getClient().getNovelChapterContextByChapterUrl(nextChapterUrl);

        this.nextReadNovel.setContext(novelChapterContext.getContext());

        this.nextReadNovel.setLastChapter(novelChapterContext.getLastChapter());

        this.nextReadNovel.setNextChapter(novelChapterContext.getNextChapter());

        this.nextReadNovel.setNovelChapterName(novelChapterContext.getNovelChapterName());

        this.nowUrl = nextChapterUrl ;
        this.flag = true ;
    }

    @Override
    public void run() {

        try {

            if (this.nextChapterUrl == null)return;

            getNextNovelChapterContextByChapterUrl(this.nextChapterUrl);

        } catch (TException e) {

            this.flag = false;

            e.printStackTrace();
        }
    }

    public ReadNovel getNextReadNovel() {
        return nextReadNovel;
    }

    public void setNextReadNovel(ReadNovel nextReadNovel) {
        this.nextReadNovel = nextReadNovel;
    }

    public String getNextChapterUrl() {
        return nextChapterUrl;
    }

    public void setNextChapterUrl(String nextChapterUrl) {
        this.nextChapterUrl = nextChapterUrl;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getNowUrl() {
        return nowUrl;
    }

    public void setNowUrl(String nowUrl) {
        this.nowUrl = nowUrl;
    }
}
