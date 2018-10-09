package com.dao;
import com.entity.*;

import java.util.*;
public interface IProviderDao {
    //查所有
    List<Provider> selectAll();

    //通过id查
    Long selectProId(String proname);

    List<Provider> selectAllProvice(Provider pro);

    //查询后分页
    List<Provider> selectPage(Map<String, Object> mp);

    //新增
    Integer insertProvider(Provider provider);

    //修改
    Integer updateProvider(Provider provider);

    //删除
    Integer delProvider(String procode);
}
