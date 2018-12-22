package org.zankel.goodsPop.module;


import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.*;
import org.zankel.goodsPop.bean.Leather;
import org.zankel.goodsPop.bean.Transaction;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@IocBean
@At("/transac")
//@Filters(@By(type = CheckSession.class,args = {"uid","/"}))
public class TransacModule {

    @Inject
    private Dao dao;

    @At("/transacPage")
    @Ok("jsp:jsp.transaction_list")
    public List<Transaction> listPage(HttpSession session){
        return dao.queryByJoin(Transaction.class,"^leather$", null);
    }

    @At("/updateRow")
    public Object updateRow(int transacId,String customerName,String leatherName,String transacVolumn,String transacStatu){
        Transaction transaction=dao.fetch(Transaction.class,transacId);
        transaction.setCustomerName(customerName);
        transaction.setLeatherName(leatherName);
        transaction.setTransacVolumn(transacVolumn);
        if((transacStatu.equals("交易完成")||transacStatu.equals("交易关闭"))&&transaction.getTransacStatu().equals("等待付清"))
            transaction.setFinishDate(new Date());
        else if(!transaction.getTransacStatu().equals("等待付清")&&transacStatu.equals("等待付清"))
            transaction.setFinishDate(null);
        transaction.setTransacStatu(transacStatu);
        if(dao.updateWith(transaction,"leather")!=null)
            return new NutMap().setv("ok",true).setv("msg","同步更新完成");
        else return new NutMap().setv("ok",false).setv("msg","同步更新失败");
    }

    @At("/deleteRow")
    public Object deleteRow(int transacId){
        if(dao.delete(Transaction.class,transacId)!=0)
            return new NutMap().setv("ok",true).setv("msg","同步更新完成");
        else return new NutMap().setv("ok",false).setv("msg","同步更新失败");
    }
}
