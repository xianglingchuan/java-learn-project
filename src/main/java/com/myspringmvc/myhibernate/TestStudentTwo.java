//package com.myspringmvc.myhibernate;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.metamodel.MetadataSources;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.jboss.logging.Logger;
//
//
//public class TestStudentTwo {
//	
//	
//	private void testShemaExprot(){
//		//创建hibernate配置对象
//		//Configuration configuration = new Configuration().configure();
//		//创建服务注册对象
//		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//		//ServiceRegistry serviceRegistry = StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//		//Hibernate 4.3.11.Final
//		StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();		
//		
//		
//		
//	}
//
//	
//	public static void main(String[] args) {
//		TestStudentTwo testStudent = new TestStudentTwo();
//		testStudent.testShemaExprot();
//	}	
//	
//}
