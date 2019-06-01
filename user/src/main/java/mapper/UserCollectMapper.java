package mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/29 - 21:39
 */
public interface UserCollectMapper {

    int insCollectNovel(@Param("uid") long uid,@Param("nid") long nid,@Param("cTimes") String cTimes);

    int insCollectNovelChapter(@Param("uid") long uid,@Param("nid") long nid,@Param("cid") long cid,@Param("novelChapterName") String novelChapterName,@Param("cTimes") String cTimes);
}
