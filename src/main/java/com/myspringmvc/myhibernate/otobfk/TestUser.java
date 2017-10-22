package com.myspringmvc.myhibernate.otobfk;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.myspringmvc.myhibernate.otobfk.entity.UserIdCard;
import com.myspringmvc.myhibernate.otobfk.entity.User;

public class TestUser {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("config/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserIdCard idCard = new UserIdCard();
		idCard.setPid("513723199801222126");
		idCard.setUname("jack");

		User user = new User();
		user.setCard(idCard);
		user.setGender("男");
		user.setBirthday(new Date());
		user.setMajor("English");
		user.setNickname("tom");

		// 先保存IdCard
		session.save(idCard);
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

}
