package com.myspringmvc.myhibernate.mtmfk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myspringmvc.myhibernate.mtmfk.entity.Student;
import com.myspringmvc.myhibernate.mtmfk.entity.Teacher;


public class TestStudent {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("config/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Teacher teacher1 = new Teacher("t001","teacher Xlc");
		Teacher teacher2 = new Teacher("t002","teacher Li");
		Teacher teacher3 = new Teacher("t003","teacher Wang");
		Teacher teacher4 = new Teacher("t004","teacher Zhang");
		
		Set<Teacher> tSet1 = new HashSet<Teacher>();
		tSet1.add(teacher1);
		tSet1.add(teacher4);
		
		Set<Teacher> tSet2 = new HashSet<Teacher>();
		tSet2.add(teacher2);
		tSet2.add(teacher4);
		
		Set<Teacher> tSet3 = new HashSet<Teacher>();
		tSet3.add(teacher2);
		tSet3.add(teacher4);	
		tSet3.add(teacher3);
		
		Set<Teacher> tSet4 = new HashSet<Teacher>();
		tSet4.add(teacher4);		
		
		Student s1 = new Student("jack01", "man", new Date(), "", "jack01");
		Student s2 = new Student("jack02", "man", new Date(), "", "jack02");
		Student s3 = new Student("lili01", "man", new Date(), "", "lili01");
		Student s4 = new Student("lili01", "man", new Date(), "", "lili01");
		
		s1.setTeachers(tSet1);
		s2.setTeachers(tSet2);
		s3.setTeachers(tSet3);
		s4.setTeachers(tSet4);
		

		
		session.save(teacher1);
		session.save(teacher2);
		session.save(teacher3);
		session.save(teacher4);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);		
		

		
		
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
