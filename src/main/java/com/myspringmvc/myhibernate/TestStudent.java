package com.myspringmvc.myhibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myspringmvc.myhibernate.entity.Student;
import com.myspringmvc.myhibernate.entity.StudentsPK;


public class TestStudent {
	
	
	private void testShemaExprot(){
		//创建hibernate配置对象
		//Configuration configuration = new Configuration().configure();
		//创建服务注册对象
		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		//ServiceRegistry serviceRegistry = StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		
		
		
		//StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();		
		
		
        System.out.println("start insert operation....");
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        Student student = new Student();
        
        StudentsPK pk = new StudentsPK();
        pk.setId("513723199892116742");
        pk.setSid("s0000001");
        
        student.setPk(pk);
        //student.setSid(1);
        student.setSname("jack");
        //student.setUuid("123456");
        //session.saveOrUpdate(student);
        Serializable  result = session.save(student);
        System.out.println(result.toString());
        
        session.getTransaction().commit();
        session.close();        
		
	}

	
	public static void main(String[] args) {
		//TestStudent testStudent = new TestStudent();
		//testStudent.testShemaExprot();
	}	
	
}
