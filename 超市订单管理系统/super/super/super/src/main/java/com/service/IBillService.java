package com.service;

import com.entity.Bill;

import java.util.*;

public interface IBillService {
    //通过id查
    Bill selectByPrimaryKey(int id);
    //新增
    Integer insertBill(Bill bill);
    //通过id查
    Long selectProId(String proname);
    //删除
    Integer delBill(String billcode);
    //修改
    Integer updateBill(Bill bill);
}
