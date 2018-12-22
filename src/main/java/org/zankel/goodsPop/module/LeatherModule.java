package org.zankel.goodsPop.module;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.zankel.goodsPop.bean.Leather;

import javax.servlet.http.HttpSession;

/**
 * @author kanghao
 * @date 18-12-22 下午3:58
 */
@IocBean
@At("leather")
public class LeatherModule {

    @Inject
    private Dao dao;

    @At("detail")
    @Ok("jsp:jsp.leather_detail")
    private Leather getDetail(HttpSession httpSession,int leatherId){
        return dao.fetch(Leather.class,leatherId);
    }


}
