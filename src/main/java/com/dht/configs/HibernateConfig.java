/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.configs;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.cfg.AvailableSettings;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Phuong
 */
@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
       LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
       factory.setPackagesToScan(new String[]  {
        "com.dht.pojo"
    });
       factory.setDataSource(dataSource());
       
       return factory;
    }
    @Bean
    public DataSource dataSource(){
            DriverManagerDataSource d = new DriverManagerDataSource();
            d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
            d.setUrl(env.getProperty("hibernate.connection.url"));
            d.setUsername(env.getProperty("hibernate.connection.username"));
            d.setPassword(env.getProperty("hibernate.connection.password"));
            
            return d;
    }
    
    private Properties hibernateProperties() {
            Properties props = new Properties();
            props.put(AvailableSettings.DIALECT,env.getProperty("hibernate.dialect"));
            props.put(AvailableSettings.SHOW_SQL,env.getProperty("hibernate.showSql"));
            
            return props;
    }
    
     @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(getSessionFactory().getObject());
        return manager;
    }
}
