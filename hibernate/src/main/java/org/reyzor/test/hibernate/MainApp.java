package org.reyzor.test.hibernate;

import java.util.Iterator;
import java.util.List;

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
		//List<Object> products = null;
		List<Object[]> products = null;
		try {
			session.beginTransaction();
			//SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title=:title WHERE id = :id");
			SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title=? WHERE id = ?");
			//queryUpdate.setParameter("title", "123");
			//queryUpdate.setParameter("id", 1);
			queryUpdate.setParameter(0, "123");
			queryUpdate.setParameter(1, 1);
			queryUpdate.executeUpdate();
			
			//SQLQuery query = session.createSQLQuery("SELECT * FROM product");
			SQLQuery querySelect = session.createSQLQuery("SELECT {p.*},{pc.*} FROM product p INNER JOIN product_category pc ON p.product_category_id=pc.id");
			//query.addEntity(Product.class);
			querySelect.addEntity("p", Product.class);
			querySelect.addJoin("pc", "p.productCategory");
			products = querySelect.list();
			
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}	
		
		for(Object[] obj: products) {
			System.out.println(((Product) obj[0]).toString() + ((ProductCategory) obj[1]).getTitle() );
		}
		/*
		for(Iterator iterator = products.iterator();iterator.hasNext(); ) {
			
			Product product = (Product)iterator.next();
			System.out.println(product.toSrting());
		}
		*/
	}

}
