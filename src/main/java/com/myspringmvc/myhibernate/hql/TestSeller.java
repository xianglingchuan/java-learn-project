package com.myspringmvc.myhibernate.hql;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.myspringmvc.myhibernate.hql.entity.Commodity;
import com.myspringmvc.myhibernate.hql.entity.Customer;
import com.myspringmvc.myhibernate.hql.entity.Order;
import com.myspringmvc.myhibernate.hql.entity.OrderItem;
import com.myspringmvc.myhibernate.hql.entity.Seller;
import com.myspringmvc.myhibernate.hql.entity.SellerCommodity;
import com.myspringmvc.myhibernate.xml.util.HibernateUtil;

import net.sf.ehcache.util.FindBugsSuppressWarnings;

public class TestSeller {

	public static void main(String[] args) {

		// findSeller();
		// findCommodity();
		// findCommodifyByObject();
		// findCommodifyByObject2();
		// findCommodifyByObject3();
		// findCommodifyByList();
		// findCommodifByMap();
		// findCommodifBySC();
		// findCustomer();
		// findWhere1();
		// findWhere2();
		// findWhere3();
		// findWhere4();
		// findWhere5();
		findWhere6();

	}

	public static void findWhere6() {
		Session session = HibernateUtil.getSession();
		String hql = "from Order ORDER where id = 1";

		Query query = session.createQuery(hql);
		Order order = (Order) query.uniqueResult();

		System.out.println("订单ID号：" + order.getId());
		Set<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem orderItem : orderItems) {
			System.out.println(orderItem.getId() + ",单价：" + orderItem.getActPrice());
		}
		System.out.println("=============================================");
		
		session.close();
	

	}

	public static void findWhere5() {
		Session session = HibernateUtil.getSession();
		String hql = "from Order ORDER where ORDER.orderItems is not empty";

		Query query = session.createQuery(hql);
		List<Order> list = query.list();
		for (Order tmp : list) {
			System.out.println("订单ID号：" + tmp.getId());
			Set<OrderItem> orderItems = tmp.getOrderItems();
			for (OrderItem orderItem : orderItems) {
				System.out.println(orderItem.getId() + ",单价：" + orderItem.getActPrice());
			}
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findWhere4() {
		Session session = HibernateUtil.getSession();
		// String hql = "from Customer where name like '张_' ";
		// String hql = "from Customer where sex='男' AND age='25' ";
		// String hql = "from Customer where sex='男' OR age='25' ";
		String hql = "from Customer where not sex='女'";

		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer tmp : list) {
			System.out.println(tmp.getName());
			System.out.println(tmp.getAge());
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findWhere3() {
		Session session = HibernateUtil.getSession();
		// String hql = "from Customer where name like '张_' ";
		String hql = "from Customer where address like '%北京%' ";

		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer tmp : list) {
			System.out.println(tmp.getName());
			System.out.println(tmp.getAge());
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findWhere2() {
		Session session = HibernateUtil.getSession();
		// String hql = "from Customer where age in (20, 40)";
		// String hql = "from Customer where age not in (20, 40)";
		// String hql = "from Customer where age between 20 and 40";
		String hql = "from Customer where age not between 20 and 40";

		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer tmp : list) {
			System.out.println(tmp.getName());
			System.out.println(tmp.getAge());
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findWhere1() {
		Session session = HibernateUtil.getSession();
		// String hql = "from Commodity where price>400";
		// String hql = "from Commodity where description is null";
		// String hql = "from Commodity where description is not null";
		String hql = "from Commodity where description = null";

		Query query = session.createQuery(hql);
		List<Commodity> list = query.list();
		for (Commodity tmp : list) {
			System.out.println(tmp.getName());
			System.out.println(tmp.getPrice());
			System.out.println("=============================================");
		}
		session.close();

	}

	public static void findCustomer() {
		Session session = HibernateUtil.getSession();
		String hql = "select distinct sex from Customer";

		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		for (Object tmp : list) {
			System.out.println(tmp);
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findCommodifBySC() {
		Session session = HibernateUtil.getSession();
		String hql = "select new com.myspringmvc.myhibernate.hql.entity.SellerCommodity(C.name as name, S.id as sellerId, S.name as sellerName) from Commodity as C, Seller as S WHERE S.id=C.seller";

		Query query = session.createQuery(hql);
		List<SellerCommodity> list = query.list();
		for (SellerCommodity tmp : list) {
			System.out.println("产品名称:" + tmp.getName());
			// 查询出来的ID号为long型
			System.out.println("商家ID:" + tmp.getSellerId());
			System.out.println("商家名称:" + tmp.getSellerName());
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findCommodifByMap() {
		Session session = HibernateUtil.getSession();
		String hql = "select new map(C.name as name, S.id as sellerId, S.name as sellerName) from Commodity as C, Seller as S WHERE S.id=C.seller";

		Query query = session.createQuery(hql);
		List<Map> list = query.list();
		for (Map tmp : list) {
			// System.out.println("产品名称:"+tmp.get("0"));
			// System.out.println("商家ID:"+tmp.get("1"));
			// System.out.println("商家名称:"+tmp.get("2"));

			System.out.println("产品名称:" + tmp.get("name"));
			System.out.println("商家ID:" + tmp.get("sellerId"));
			System.out.println("商家名称:" + tmp.get("sellerName"));
			System.out.println("=============================================");
		}
		session.close();
	}

	public static void findCommodifyByList() {
		Session session = HibernateUtil.getSession();
		String hql = "select new list(C.name, S.id, S.name) from Commodity as C, Seller as S WHERE S.id=C.seller";

		Query query = session.createQuery(hql);
		List<List> list = query.list();
		for (List tmp : list) {
			System.out.println("产品名称:" + tmp.get(0));
			System.out.println("商家ID:" + tmp.get(1));
			System.out.println("商家名称:" + tmp.get(2));
		}
		session.close();
	}

	public static void findCommodifyByObject3() {
		Session session = HibernateUtil.getSession();
		String hql = "select C.name, S.id, S.name from Commodity as C, Seller as S WHERE S.id=C.seller";

		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println("产品名称:" + objects[0]);
			System.out.println("商家ID:" + objects[1]);
			System.out.println("商家名称:" + objects[2]);
		}
		session.close();
	}

	public static void findCommodifyByObject2() {
		Session session = HibernateUtil.getSession();
		String hql = "select C.name from Commodity as C";

		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		for (Object objects : list) {
			System.out.println("id:" + objects);
		}
		session.close();
	}

	public static void findCommodifyByObject() {
		Session session = HibernateUtil.getSession();
		String hql = "select C.id, C.name, C.price from Commodity as C";

		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println("id:" + objects[0]);
			System.out.println("name:" + objects[1]);
			System.out.println("price:" + objects[2]);
		}
		session.close();
	}

	public static void findCommodity() {
		Session session = HibernateUtil.getSession();
		// String hql = "from Commodity";
		// String hql = "from com.myspringmvc.myhibernate.hql.entity.Commodity";
		String hql = "from Commodity as commodity";

		Query query = session.createQuery(hql);
		List<Commodity> list = query.list();
		for (Commodity commodity : list) {
			System.out.println("产品名称:" + commodity.getName() + "，商家名称:" + commodity.getSeller().getName());
		}

		session.close();
	}

	public static void findSeller() {
		Session session = HibernateUtil.getSession();

		String hql = "from Seller";
		Query query = session.createQuery(hql);
		List<Seller> list = query.list();
		for (Seller seller : list) {
			System.out.println(seller.toString());
		}

		session.close();
	}

}
