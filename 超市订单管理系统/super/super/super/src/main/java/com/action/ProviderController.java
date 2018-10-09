package com.action;

import com.alibaba.fastjson.JSON;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class ProviderController {
    @Autowired
    private IUserService us;
    @Autowired
    private IProviderService ps;

    @RequestMapping(value = "/allProvider",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object allProvider(HttpSession session, String page, String rows, String sort, String order,Provider provider)throws Exception{
        String js="";
        System.out.println("------ppppp"+provider);
        System.out.println(" page = "+page);//第几页
        System.out.println(" rows = "+rows);//一页几行
        System.out.println(" sort = "+sort);//按哪个字段排
        System.out.println(" order = "+order);// 正序还是反序
        ProviderData dt = new ProviderData();
        List<Provider> list=ps.selectAllProvice(provider);
        List<Provider> slist=ps.selectPagePro(page,rows,provider);
        dt.setTotal(list.size());// 如果是分页要放总记录数
        System.out.println("----list.size()"+list.size());
        dt.setRows(slist);
       js = JSON.toJSONString(dt);
        System.out.println(" json = "+js);
        return js;
    }
    @RequestMapping("/addProvider")
    public void addProvider(HttpSession session,HttpServletResponse response,Provider provider) throws Exception {
        PrintWriter out = response.getWriter();
        Users user = (Users)session.getAttribute("userinfo");
        provider.setCreatedby(user.getId());
        Integer num = ps.insertProvider(provider);
        if (num > 0) {
            out.print("true");
        } else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
    @RequestMapping("/updateProvider")
    public void updateProvider(HttpServletResponse response,TProvider tprovider) throws Exception {
        System.out.println("---------UPDATE");
        System.out.println("---------"+tprovider);
        PrintWriter out = response.getWriter();
        Provider provider = new Provider();
        provider.setId(tprovider.getId());
        provider.setProname(tprovider.getProname());
        provider.setProcontact(tprovider.getProcontact());
        provider.setProphone(tprovider.getProphone());
        provider.setProfax(tprovider.getProfax());
        provider.setCreationdate(tprovider.getCreationdate());
        Integer num=ps.updateProvider(provider);
        if(num > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/delProvider")
    public void delProvider(HttpServletResponse response, String procode) throws Exception{

        System.out.println("-----------------delProvider");
        PrintWriter out = response.getWriter();
        System.out.println("-----------------procode = "+procode);
        Integer num = ps.delProvider(procode);
        System.out.println("-------------num = "+num);
        if(num > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
