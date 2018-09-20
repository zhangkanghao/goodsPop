package org.zankel.goodsPop;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MainSetup implements Setup {

    public static Ioc ioc;

    @Override
    public void init(NutConfig nutConfig) {
        MainSetup.ioc = nutConfig.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "org.zankel.goodsPop", false);
    }

    @Override
    public void destroy(NutConfig nutConfig) {

    }
}
