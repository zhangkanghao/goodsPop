package org.zankel.goodsPop;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import javax.servlet.http.HttpSession;

/**
 * Created by likole on 7/23/18.
 */
@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = {"*js", "ioc/",
        "*anno", "org.zankel.goodsPop",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules()
@Ok("json:full")
@Fail("jsp:jsp.500")
public class MainModule {

    @At("/")
    @Ok("re")
    public String index(HttpSession session) {
        if (session.getAttribute("uid") == null) return ">>:/user/loginpage";
        else return "jsp.index";
    }


}
