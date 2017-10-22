package com.myspringmvc.myhibernate.mtofk;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myspringmvc.myhibernate.mtofk.entity.ClassRoom;
import com.myspringmvc.myhibernate.mtofk.entity.Student;

public class TestStudent {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("config/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ClassRoom classRoom = new ClassRoom("0001","EnglishClass");
		Student student = new Student();
		student.setClassRoom(classRoom);
		student.setGender("man");
		student.setBirthday(new Date());
		student.setMajor("");
		student.setNickname("jack");
		student.setSname("tom");
		
		Student student2 = new Student();
		student2.setClassRoom(classRoom);
		student2.setGender("man");
		student2.setBirthday(new Date());
		student2.setMajor("");
		student2.setNickname("lili");
		student2.setSname("lili");
		
		
		session.save(classRoom);
		session.save(student);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
	}
}
