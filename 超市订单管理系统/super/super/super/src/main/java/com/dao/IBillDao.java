package com.dao;

import com.entity.Bill;

import java.util.*;

public interface IBillDao {
    //通过id查
    Bill selectByPrimaryKey(int id);
    //查所有
    List<Bill> selectAll(Bill bill);
    //分页
    List<Bill> selectPageBill(Map<String,Object> mp);
    //新增
    Integer insertBill(Bill bill);
    //删除
    Integer delBill(String billcode);
    //修改
    Integer updateBill(Bill bill);
}
