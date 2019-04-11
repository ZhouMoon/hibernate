package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author: LiGX
 * @Date: 2019-04-09 上午 10:16
 */
public class HibernateUtil {
    private static SessionFactory SESSION_FACTORY=null;
    static {
        Configuration configuration=new Configuration().configure();
        SESSION_FACTORY= configuration.buildSessionFactory();
//         注册服务
//        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
//        SESSION_FACTORY= new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }

}
