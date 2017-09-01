package org.reyzor.test.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.reyzor.test.hibernate.model.Product;
import org.reyzor.test.hibernate.model.ProductCategory;
import org.reyzor.test.hibernate.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();		
		
		List<Product> products = null;
		int[] ma = {1,2,3};
		
		try {
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Product.class);
			
			criteria.add(Restrictions.eq("title", "123"));//select * from product where title = "123"
			criteria.add(Restrictions.eq("id", ma));//select * from product where title="123" and id in (1,2,3)
			criteria.add(Restrictions.or(
					Restrictions.not(
							Restrictions.in(
									"id",ma)))));
			
			products = criteria.list();
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}	
		
		for(Product product: products) {
			System.out.println(product.toSrting());
		}
		
	}

}
