package com.myspringmvc.myhibernate.xml;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.myspringmvc.myhibernate.xml.entity.GradeXml;
import com.myspringmvc.myhibernate.xml.entity.StudentXml;
import com.myspringmvc.myhibernate.xml.util.HibernateUtil;

public class TestDemo02 {
	
	public static void main(String[] args) {
		//insert();	
		findStudent();
	}
	
	
	public static void insert(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		
		GradeXml gradeXml = new GradeXml("软件开发五班", "好学软件开发五班");
		StudentXml studentXml1 = new StudentXml("五班(李明)", "男");
		StudentXml studentXml2 = new StudentXml("五班(王丽)", "女");

		Set<StudentXml> students = new HashSet<StudentXml>();
		students.add(studentXml1);
		students.add(studentXml2);
		gradeXml.setStudents(students);
		
		studentXml1.setGrade(gradeXml);
		studentXml2.setGrade(gradeXml);
		
		session.save(gradeXml);  //级联操作，当保存班级时自动保存学生
		//session.save(studentXml1);
		//session.save(studentXml2);
		
		
		session.getTransaction().commit();
		session.clear();
	}
	
    public static void findStudent(){
		Session session = HibernateUtil.getSession();
		session.beginTransaction();	
		
		//StudentXml studentXml = new StudentXml();
		
		StudentXml studentXml =  session.get(StudentXml.class, 4);
		System.out.println("学生名称:"+studentXml.getSname()+", 班级:"+studentXml.getGrade().getGname());
		
		
		session.getTransaction().commit();
		session.clear();
    }
	
	

}
