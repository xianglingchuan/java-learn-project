package com.myspringmvc.myhibernate.xml.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static Session session;
	
	static{
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml").build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	}
		
	
	public static Session getSession(){
		session =  sessionFactory.openSession();
		return session;
	}
	
	
	public static void closeSession(){
		if(session!=null){
			session.close();
		}
	}
}
