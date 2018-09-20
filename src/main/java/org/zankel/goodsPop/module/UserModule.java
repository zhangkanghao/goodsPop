package org.zankel.goodsPop.module;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.ViewModel;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;
import org.zankel.goodsPop.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@IocBean
@At("/user")
@Filters(@By(type = CheckSession.class,args = {"uid","/"}))
public class UserModule {

    @Inject
    private Dao dao;


    @Ok("re")
    @Filters
    @At
    public String loginPage(HttpSession session, ViewModel model) {
        if (session.getAttribute("uid") != null) return ">>:/";
//        String csrf=Toolkit.getUUID();
//        CsrfUtil.add(session,csrf);
//        model.setnx("csrf",csrf);
        return "jsp:jsp.login";
    }

    @At
    @Filters
    public Object login(User user, HttpSession session, HttpServletRequest httpServletRequest){

        //检查用户名和密码格式
        String msg=checkUsernameAndPasswd(user.getPhone(),user.getPassword());
        if(msg!=null)return new NutMap().setv("ok",false).setv("msg",msg);

        //检查用户

        User check=dao.fetch(User.class,user.getPhone());
        if(check==null)return new NutMap().setv("ok",false).setv("msg","用户不存在");
        if(!user.getPassword().equals(check.getPassword()))return new NutMap().setv("ok",false).setv("msg","用户名与密码不匹配");

        session.setAttribute("uid",check.getPhone());
        session.setAttribute("user",check);
        //添加登陆日志
        //TODO LogService
        return new NutMap().setv("ok",true);
    }


    @At
    @Filters
    public Object register(User user,HttpSession session){

        return null;
    }



    private String checkUsernameAndPasswd(String username,String password){
        if(username==null)return "用户名不能为空";
        else if(!Strings.isMobile(username))return "请输入用户名（手机号）";
        if(password==null)return "密码不能为空";
        return null;
    }



}
