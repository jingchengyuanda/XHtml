package com.service;
import java.util.*;
import com.entity.*;
public interface IUserService {
    //查所有
    List<Users> selectAll();
    //登录
    Users login(Users u);
    //分页
    List<Bill> selectAllBill(Bill bill);

    List<Bill> selectPageBill(String page,String rows,Bill bill);
    //分页
    List<Users> selectPageUser(String page,String rows,Users users);
    //新增
    Integer insertUser(Users user);
    //删除
    Integer delUser(String usercode);
    //修改
    Integer updateUser(Users user);
}
