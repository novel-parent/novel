package service.impl;

import bean.History;
import bean.HistorySearch;
import bean.SearchHistoryNovel;
import mapper.HistoryMapper;
import myexception.SearchHistoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import service.HistoryService;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/26 - 21:46
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    /**
     * 更新用户  输入记录的功能
     * @param uid
     * @param key
     * @return
     */
    @Override
    public int insHistory(long uid, String key) {

        int index = historyMapper.insHistory(uid, key);

        return index;
    }

    @Override
    public List<HistorySearch> selForSearchHistory(long uid) throws SearchHistoryException {

        List<HistorySearch> searchList = historyMapper.selForHistorySearch(uid);

        if( searchList==null){
            throw new SearchHistoryException("暂无搜索信息");
        }

        return searchList;
    }
}
