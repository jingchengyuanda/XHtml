package com.service.impl;

import com.entity.*;
import com.dao.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@MapperScan("com.dao")
@Service("providerService")
public class ProviderService implements  IProviderService{


    @Autowired
    private IProviderDao providerDao;

    public Integer updateProvider(Provider provider) {
        return providerDao.updateProvider(provider);
    }
    public Integer insertProvider(Provider provider) {
        return providerDao.insertProvider(provider);
    }
    public List<Provider> selectAllProvice() {
        return providerDao.selectAll();
    }


    public List<Provider> selectAllProvice(Provider pro) {
        return providerDao.selectAllProvice(pro);
    }

    public Integer delProvider(String procode) {
        return providerDao.delProvider(procode);
    }

    public List<Provider> selectPagePro(String page, String rows, Provider pro) {
        Integer pages = Integer.parseInt(page);
        Integer row = Integer.parseInt(rows);
        Map<String,Object> mp = new HashMap<String,Object>();
        Integer pag = (pages-1)*row;
        mp.put("procode","%"+pro.getProcode()+"%");
        mp.put("proname","%"+pro.getProname()+"%");
        mp.put("page",pag);
        mp.put("rows",row);
        System.out.println(mp);
        List<Provider> ss = providerDao.selectPage(mp);
        System.out.println(ss);
        return ss;
    }

}
