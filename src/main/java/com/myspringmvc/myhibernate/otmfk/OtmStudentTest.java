package com.myspringmvc.myhibernate.otmfk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myspringmvc.myhibernate.otmfk.entity.OtmClassRoom;
import com.myspringmvc.myhibernate.otmfk.entity.OtmStudent;



public class OtmStudentTest {
	
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("config/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		OtmClassRoom classRoom = new OtmClassRoom("0001","EnglishClass");
		OtmClassRoom classRoom2 = new OtmClassRoom("0002","MusicClass");
		
		OtmStudent s1 = new OtmStudent("jack01", "man", new Date(), "", "jack01");
		OtmStudent s2 = new OtmStudent("jack02", "man", new Date(), "", "jack02");
		OtmStudent s3 = new OtmStudent("lili01", "man", new Date(), "", "lili01");
		OtmStudent s4 = new OtmStudent("lili01", "man", new Date(), "", "lili01");
		
		
		Set<OtmStudent> liStudents = new HashSet<OtmStudent>();
		liStudents.add(s1);
		liStudents.add(s2);
		
		Set<OtmStudent> liStudents2 = new HashSet<OtmStudent>();
		liStudents2.add(s3);
		liStudents2.add(s4);
		
		
		classRoom.setStudents(liStudents);
		classRoom2.setStudents(liStudents2);
		
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		session.save(classRoom);
		session.save(classRoom2);
		
		session.getTransaction().commit();
		session.close();
	}

}
