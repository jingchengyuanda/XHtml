package com.dao;
import java.util.*;
import com.entity.*;
public interface IUsersDao {
   //查所有
   List<Users> selectAll();
   //登录
   Users login(Users u);
   //分页
   List<Users> selectPageUser(Map<String,Object> mp);
   //新增
   Integer insertUser(Users user);
   //删除
   Integer delUser(String usercode);
   //修改
   Integer updateUser(Users user);
}
