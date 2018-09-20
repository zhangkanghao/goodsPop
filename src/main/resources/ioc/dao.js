var ioc = {
    conf: {
        type: "org.nutz.ioc.impl.PropertiesProxy",
        fields: {
            paths: ["custom/"]//扫描resources/custom下的所有properties，idea中resources就相当于eclipse目录结构下的conf
        }
    },
    dataSource: {
        factory: "$conf#make",
        args: ["com.alibaba.druid.pool.DruidDataSource", "db."],
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            create: "init",
            depose: 'close'
        }
    },
    dao: {
        type: "org.nutz.dao.impl.NutDao",
        args: [{refer: "dataSource"}]
    }
};
