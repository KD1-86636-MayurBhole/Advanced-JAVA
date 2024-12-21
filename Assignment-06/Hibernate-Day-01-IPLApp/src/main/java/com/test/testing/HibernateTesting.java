package com.test.testing;

import static com.test.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

public class HibernateTesting 
{
	public static void main(String[] args) {
		try(SessionFactory factory = getSessionFactory()){
			System.out.println("Testing...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
