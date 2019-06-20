package util;

import com.yc.bean.ReadNovel;
import com.yc.thrift.client.NovelThriftClient;
import org.apache.thrift.TException;

/**
 * @author LX
 * @date 2019/6/19 - 17:53
 */
public class NovelClientUtil {

    public static String getNovelChapters(String novelChaptersUrl) throws TException {

        NovelThriftClient novelThriftClient = new NovelThriftClient();

        String list = novelThriftClient.getNovelChapterListByNovelUrl(novelChaptersUrl);

        novelThriftClient.getTransport().close();

        return list;
    }

    public static ReadNovel getNovelChapterContext(String novelChapterUrl) throws TException {

        NovelThriftClient novelThriftClient = new NovelThriftClient();

        ReadNovel novel = novelThriftClient.getNovelChapterContextByChapterUrl(novelChapterUrl);

        novelThriftClient.getTransport().close();

        return novel;
    }

}
