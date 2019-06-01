package service;

import MyException.IntroductionNovelChaptersException;
import MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import org.apache.thrift.TException;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
public interface VipNovelService {

    ReadNovel getNovelChapterContext(long nid , long cid , String uid) throws IntroductionNovelChaptersException;

    String getIntroductionNovelChapters(long nid ,String uid) throws ReadNovelChapterContextException;
}
