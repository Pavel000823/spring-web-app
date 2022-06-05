package com.geek.webapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class MyAppBdSessionFactory {

    private SessionFactory factory;

    @PostConstruct
    private void init() {
       // PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("conf/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }
}
