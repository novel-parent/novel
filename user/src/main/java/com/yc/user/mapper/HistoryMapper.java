package com.yc.user.mapper;


import com.yc.user.bean.HistorySearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/26 - 21:50
 */
public interface HistoryMapper {

    List<HistorySearch> selForHistorySearch(@Param("uid") long uid);

    int insHistory(@Param("uid") long uid,@Param("key") String key);

}
