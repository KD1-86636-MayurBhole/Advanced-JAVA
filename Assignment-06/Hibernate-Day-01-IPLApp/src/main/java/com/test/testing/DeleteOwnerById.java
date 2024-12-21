package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.OwnerDao;
import com.test.dao.OwnerDaoImpl;
import com.test.utils.HibernateUtils;

public class DeleteOwnerById 
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
				OwnerDao oDao = new OwnerDaoImpl();
				System.out.print("Enter owner id to delete : ");
				String msg = oDao.deleteOwner(sc.nextLong());
				System.out.println("Message : " + msg);
		}
	}

}
