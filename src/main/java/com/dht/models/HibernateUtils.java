/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.models;


import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Phuong
 */
public class HibernateUtils {
    private static final SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }
    
    
    static{
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MYSQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/mysaledbv3");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "Phuong@300800");
        props.put(Environment.SHOW_SQL, "true");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        conf.setProperties(props);
        
        //conf.addAnnotatedClass(Category.class);
        factory = conf.buildSessionFactory(registry);
    }
}
