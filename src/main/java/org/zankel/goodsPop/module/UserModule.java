package org.zankel.goodsPop.module;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
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
import java.util.Date;
import java.util.List;

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
        String msg=checkEmailAndPasswd(user.getEmail(),user.getPassword());
        if(msg!=null)return new NutMap().setv("ok",false).setv("msg",msg);

        //检查用户
        User check=dao.fetch(User.class,user.getEmail());
        if(check==null)return new NutMap().setv("ok",false).setv("msg","用户不存在");
        if(!user.getPassword().equals(check.getPassword()))return new NutMap().setv("ok",false).setv("msg","用户名与密码不匹配");

        session.setAttribute("uid",check.getUserId());
        session.setAttribute("user",check);
        //添加登陆日志
        //TODO LogService
        return new NutMap().setv("ok",true);
    }

    @At
    @Filters
    public Object checkEmail(String email,HttpSession httpSession){
        User check=dao.fetch(User.class,email);
        if(check!=null)return new NutMap().setv("ok",false).setv("msg","邮箱已被注册").setv("valid",false);
        return new NutMap().setv("ok",true).setv("valid",true);
    }

    @At
    @Filters
    public Object register(User user,HttpSession session){

        //验证手机，密码格式
        String msg=checkEmailAndPasswd(user.getEmail(),user.getPassword());
        if(msg==null)return new NutMap().setv("ok",false).setv("msg",msg);

        //验证数据库
        User exist=dao.fetch(User.class,user.getEmail());
        if(exist!=null)return new NutMap().setv("ok",false).setv("msg","该邮箱已被注册");

        //注册
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user=dao.insert(user);

        //TODO LogService

        //登陆
        session.setAttribute("uid",user.getUserId());

        return new NutMap().setv("ok",true);
    }

    @At
    public Object getList(HttpSession session, Pager pager){
        return dao.query(User.class,Cnd.NEW(),pager);
    }


    private String checkEmailAndPasswd(String username,String password){
        if(username==null)return "用户名(邮箱)不能为空";
        else if(!Strings.isEmail(username))return "邮箱格式不正确";
        if(password==null)return "密码不能为空";
        return null;
    }



}
