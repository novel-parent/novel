package service;


import MyException.IntroductionNovelChaptersException;
import MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import org.apache.thrift.TException;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
public interface VisitorNovelService {

    String getIntroductionNovelChapters(long nid) throws IntroductionNovelChaptersException;

    ReadNovel getNovelChapterContext(long nid , long cid ) throws ReadNovelChapterContextException;
}
