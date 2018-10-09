package com.service.impl;

import com.dao.*;
import com.entity.Bill;
import com.service.IBillService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@MapperScan(basePackages = "com.dao")
@Service("billService")
public class BillService implements IBillService {
    @Autowired
    private IBillDao billDao;
    @Autowired
    private IProviderDao providerDao;

    public Bill selectByPrimaryKey(int id) {
        return billDao.selectByPrimaryKey(id);
    }

    public Integer delBill(String billcode) {
        return billDao.delBill(billcode);
    }


    public Integer updateBill(Bill bill) {
        return billDao.updateBill(bill);
    }

    public Long selectProId(String proname) {
        return providerDao.selectProId(proname);
    }

    public Integer insertBill(Bill bill) {
        return billDao.insertBill(bill);
    }
}
