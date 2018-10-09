package com.service.impl;

import com.entity.*;
import com.dao.*;
import java.util.*;

import com.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("userService")
public class UserService implements IUserService{

    @Autowired
    private IUsersDao usersDao ;
    @Autowired
    private IBillDao billDao ;
    @Autowired
    private IProviderDao providerDao;



    public Integer delUser(String usercode) {
        return usersDao.delUser(usercode);
    }


    public Integer updateUser(Users user) {
        return usersDao.updateUser(user);
    }

    public List<Users> selectPageUser(String page, String rows, Users users) {
        Integer pages = Integer.parseInt(page);
        Integer row = Integer.parseInt(rows);
        Map<String,Object> mp = new HashMap<String,Object>();
        Integer pag = (pages-1)*row;
        mp.put("page", pag);
        mp.put("rows", row);
        mp.put("username",users.getUsername());
        mp.put("userrole",users.getUserrole());
        System.out.println("--page = "+mp);
        return usersDao.selectPageUser(mp);
    }

    public Integer insertUser(Users user) {
        return usersDao.insertUser(user);
    }

    public Users login(Users u) {
        return usersDao.login(u);
    }

    public List<Bill> selectAllBill(Bill bill) {
        bill.setProductname("%"+bill.getProductname()+"%");
        return billDao.selectAll(bill);
    }

    public List<Bill> selectPageBill(String page, String rows, Bill bill) {
        Integer pages = Integer.parseInt(page);
        Integer row = Integer.parseInt(rows);
        Map<String,Object> mp = new HashMap<String,Object>();
        Integer pag = (pages-1)*row;
        mp.put("page", pag);
        mp.put("rows", row);
        mp.put("productname",bill.getProductname());
        mp.put("ispayment",bill.getIspayment());
        mp.put("proname",bill.getProname());
        System.out.println("--page = "+mp);
        return billDao.selectPageBill(mp);
    }

    public List<Users> selectAll() {
        return usersDao.selectAll();
    }
}
