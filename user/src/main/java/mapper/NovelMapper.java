package mapper;

import bean.SearchHistoryNovel;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/26 - 21:53
 */
public interface NovelMapper {

    SearchHistoryNovel selForSearchHistoryNovel(@Param("nid") long nid);
}
