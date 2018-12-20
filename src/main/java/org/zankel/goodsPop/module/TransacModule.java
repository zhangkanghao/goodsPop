package org.zankel.goodsPop.module;


import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.zankel.goodsPop.bean.Transaction;

import javax.servlet.http.HttpSession;
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

}
