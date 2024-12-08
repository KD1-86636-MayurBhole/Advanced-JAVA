package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;
public class HibernateTester {

	public static void main(String[] args) {
		try(SessionFactory sf=getSessionFactory())
		{
			System.out.print("Hibernate is working!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
