package com.action;

import com.alibaba.fastjson.JSON;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService us;

    @RequestMapping("/iflogin")
    public void login(HttpSession session,String usercode, String password, HttpServletResponse response) throws Exception{
        System.out.println("uname="+usercode);
        System.out.println("pwd="+password);
        PrintWriter out =response.getWriter();
        Users user =new Users();
        user.setUsercode(usercode);
        user.setUserpassword(password);

        Users temp =us.login(user);
        session.setAttribute("userinfo",temp);
        if(temp != null){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/allUser",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object allUser(HttpSession session, String page, String rows, String sort, String order,Users users)throws Exception{
        String js="";
        System.out.println(" page = "+page);//第几页
        System.out.println(" rows = "+rows);//一页几行
        System.out.println(" sort = "+sort);//按哪个字段排
        System.out.println(" order = "+order);// 正序还是反序
        List<Users> list=us.selectAll();
        List<Users> slist=us.selectPageUser(page,rows,users);
        UsersData dt = new UsersData();
        dt.setTotal(list.size());// 如果是分页要放总记录数
        dt.setRows(slist);
        js = JSON.toJSONString(dt);
        //System.out.println(" json = "+js);
        return js;
    }
    @RequestMapping("/addUser")
    public void addUser(HttpSession session,HttpServletResponse response,Users users) throws Exception {
        PrintWriter out = response.getWriter();
        Integer num = us.insertUser(users);
        if (num > 0) {
            out.print("true");
        } else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
    @RequestMapping("/updateUser")
    public void updateUser(HttpServletResponse response,TUsers tuser) throws Exception {
        System.out.println("---------UPDATE");
        System.out.println("---------"+tuser);
        PrintWriter out = response.getWriter();
        Users user = new Users();
        user.setId(tuser.getId());
        user.setUsername(tuser.getUsername());
        user.setGender(tuser.getGender());
        user.setPhone(tuser.getPhone());
        user.setUserrole(tuser.getUserrole());
        user.setCreationdate(tuser.getCreationdate());
        Integer num=us.updateUser(user);
        if(num > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/delUser")
    public void delUser(HttpServletResponse response, String usercode) throws Exception{

        System.out.println("-----------------delUser");
        PrintWriter out = response.getWriter();
        System.out.println("-----------------procode = "+usercode);
        Integer num = us.delUser(usercode);
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
