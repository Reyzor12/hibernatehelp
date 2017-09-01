package org.reyzor.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.reyzor.test.hibernate.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}	
		
	}

}
