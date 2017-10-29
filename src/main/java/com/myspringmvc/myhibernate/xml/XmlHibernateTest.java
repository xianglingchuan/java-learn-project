package com.myspringmvc.myhibernate.xml;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.sql.Delete;

import com.myspringmvc.myhibernate.xml.entity.GradeXml;
import com.myspringmvc.myhibernate.xml.entity.StudentXml;
import com.myspringmvc.myhibernate.xml.util.HibernateUtil;

public class XmlHibernateTest {

	public static void main(String[] args) {

		//add();
		//findGrade();
		//update();
		delete();
	}
	
	
	//更新
	public static void update(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		
		//将数生id=3的调换到=1的班级上去
		GradeXml gradeXml = session.get(GradeXml.class, 1);		
		StudentXml studentXml = session.get(StudentXml.class, 3);
		gradeXml.getStudents().add(studentXml);
		session.save(gradeXml);
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
	
	
	//删除
	public static void delete(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		
		//删除学生id=3记录
		StudentXml studentXml = session.get(StudentXml.class, 3);
		session.delete(studentXml);
		
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();	
	}
	
	

	//查询
	public static void findGrade(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		
		GradeXml gradeXml = (GradeXml)session.get(GradeXml.class, 1);
		System.out.println(gradeXml.getGname());
		Set<StudentXml> studentXmls = gradeXml.getStudents();
		for (StudentXml studentXml : studentXmls) {
			System.out.println("学生姓名:"+studentXml.getSname());
		}
		session.getTransaction().commit();
		HibernateUtil.closeSession();		
	}
	
	
	
	public static void add() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		GradeXml gradeXml = new GradeXml("软件开发一班", "好学软件开发一班");
		StudentXml studentXml1 = new StudentXml("李明", "男");
		StudentXml studentXml2 = new StudentXml("王丽", "女");

		Set<StudentXml> studentXmls = new HashSet<StudentXml>();
		studentXmls.add(studentXml1);
		studentXmls.add(studentXml2);
		gradeXml.setStudents(studentXmls);

		session.save(gradeXml);
		session.save(studentXml1);
		session.save(studentXml2);
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}	
}