package com.myspringmvc.myhibernate.otofk;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hankcs.hanlp.dependency.nnparser.util.std;
import com.myspringmvc.myhibernate.otofk.entity.IdCard;
import com.myspringmvc.myhibernate.otofk.entity.User;

public class TestUser {

	public static void execute() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("config/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		IdCard idCard = new IdCard();
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

	public static void main(String[] args) {
		//TestUser.execute();

	}

}
