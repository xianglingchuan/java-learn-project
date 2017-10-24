package com.myspringmvc.myhibernate.mycatch;

import org.hibernate.Session;

import com.myspringmvc.myhibernate.mycatch.entity.Teacher;
import com.myspringmvc.myhibernate.mycatch.util.HibernateUtil;

public class TestCatch {
	
	public static void main(String[] args) {
		
		/**
	   观察实例代码段，发现以下问题:
	   1、在二次查询同一个对象时，并没有再次执行数据库查询 
	   2、在不同的Session中多次查询同一个对象时，会执行多次数据库查询
	   3、一级缓存中，持久化类的每个实例都有唯一的OID
	 	 * */
		
		Session session = HibernateUtil.getSession();
		Teacher teacher = (Teacher)session.get(Teacher.class, 1);
		System.out.println("teacher:"+teacher.toString());
		
		//session = HibernateUtil.getSession();
		//evict清除一级缓存中的指定对象
		//session.evict(teacher);
		//clear清除一级缓存中的所有对象
		//session.clear();
		
//		teacher = (Teacher)session.get(Teacher.class, 1);
//		System.out.println("teacher:"+teacher.toString());
		
		
//		Query query = session.createQuery("from Teacher");
//		List<Teacher> list =  query.list();
//		for (Teacher teacher : list) {
//			System.out.println("teacher.tname:"+teacher.getTname());
//		}
		
		
		
		
		
		
	}

}
