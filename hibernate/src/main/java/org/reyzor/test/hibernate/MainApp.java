package org.reyzor.test.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.reyzor.test.hibernate.model.Product;
import org.reyzor.test.hibernate.model.ProductCategory;
import org.reyzor.test.hibernate.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		//List<Product> products = null;
		List<Product> products = null;
		
		try {
			session.beginTransaction();
		
			//Query query = session.createQuery("FROM Product as p JOIN FETCH p.productCategory as pc");
			//Query query = session.createQuery("SELECT p FROM Product as p INNER JOIN p.productCategory as pc WITH pc.id = ?");
			//query.setParameter(0, 1L);
			//products = query.list();
			
			Product product = new Product();
			session.save(product);
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}	
		
		for(Product product:products) {
			System.out.println(product.toString());
		}
		/*
		for(Product product:products) {
			System.out.println(product.toSrting());
		}
		*/
	}

}
