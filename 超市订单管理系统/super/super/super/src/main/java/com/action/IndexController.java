package com.action;
import java.io.PrintWriter;
import java.util.*;
import com.entity.*;
import com.service.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IUserService us;
    @Autowired
    private IBillService bs;
    @Autowired
    private IProviderService ps;

    @RequestMapping(value = "/allBill", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object allBill(HttpSession session,String page,String rows,String sort,String order,Bill bill) throws Exception{
        String js = "";
        //Users user = (Users) session.getAttribute("userinfo");
        //System.out.println("----------------hahha ");
        System.out.println("--------"+bill);
        //boolean ck = bill.getProname()==null&&bill.getProductname()==null&&bill.getIspayment()==null;
        BillData bd = new BillData();
        List<Bill> list = us.selectAllBill(bill);
        List<Bill> slist = us.selectPageBill(page,rows,bill);
        for(Bill bi:slist){
            Provider pr = bi.getProvider();
            bi.setProname(pr.getProname());
        }
        bd.setTotal(list.size());
        System.out.println("----list.size()"+list.size());
        bd.setRows(slist);
        //System.out.println(slist);
        js = JSON.toJSONString(bd);
        System.out.println("----------json = " +js);

        return js;
    }

    @RequestMapping("/addBill")
    public void addBill(HttpSession session,HttpServletResponse response, Bill bill) throws Exception {
        PrintWriter out = response.getWriter();
        String proname = bill.getProname();
        Users user = (Users)session.getAttribute("userinfo");
        Long proId = bs.selectProId(proname);
        System.out.println("-----------proid" + proId);
        bill.setProviderid(proId);
        bill.setCreatedby(user.getId());
        Integer num = bs.insertBill(bill);
        if (num > 0) {
            out.print("true");
        } else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
    @RequestMapping(value = "/getProname",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getProname(){
        String js = "";
        List<Provider> plist = ps.selectAllProvice();
        js = JSON.toJSONString(plist);
        System.out.println("----------json = " +js);
        return js;
    }

    @RequestMapping("/updateBill")
    public void updateBill(HttpServletResponse response,TBill tbill) throws Exception {
        System.out.println("---------UPDATE");
        System.out.println("---------"+tbill);
        PrintWriter out = response.getWriter();
        Bill bill = new Bill();
        bill.setId(tbill.getId());
        bill.setBillcode(tbill.getBillcode());
        bill.setIspayment(tbill.getIspayment());
        bill.setCreationdate(tbill.getCreationdate());
        bill.setProductname(tbill.getProductname());
        bill.setTotalprice(tbill.getTotalprice());
        bill.setProname(tbill.getProname());
        Integer num = bs.updateBill(bill);
        if(num > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/getUserName")
    public void getUserName(HttpServletResponse response, HttpSession session) throws Exception{
        //request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //System.out.println("-----------------getUserName");
        PrintWriter out = response.getWriter();
        Users u = (Users) session.getAttribute("userinfo");
        String username = u.getUsername();
        //System.out.println("-----------------"+username);
        out.print(username);
        out.flush();
        out.close();
    }
    @RequestMapping("/delBill")
    public void delDemo(HttpServletResponse response, String billcode) throws Exception{

        System.out.println("-----------------delBill");
        PrintWriter out = response.getWriter();
        System.out.println("-----------------billcode = "+billcode);
        Integer num = bs.delBill(billcode);
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
