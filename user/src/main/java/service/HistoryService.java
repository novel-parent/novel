package service;

import bean.HistorySearch;
import myexception.SearchHistoryException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/26 - 21:46
 */
public interface HistoryService {

    List<HistorySearch> selForSearchHistory(@Param("uid") long uid) throws SearchHistoryException;

    int insHistory(long uid,String key);
}
