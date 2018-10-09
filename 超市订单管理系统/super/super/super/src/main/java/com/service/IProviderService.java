package com.service;
import java.util.*;
import com.entity.*;
public interface IProviderService {
    //条件查询
    List<Provider> selectAllProvice();

    List<Provider> selectAllProvice(Provider pro);
    //查询后分页
    List<Provider> selectPagePro(String page,String rows,Provider pro);
    //新增
    Integer insertProvider(Provider provider);
    //修改
    Integer updateProvider(Provider provider);
    //删除
    Integer delProvider(String procode);
}
