package org.reyzor.test.hibernate;

import org.hibernate.SessionFactory;
import org.reyzor.test.hibernate.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	}

}
