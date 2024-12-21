package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.OwnerDao;
import com.test.dao.OwnerDaoImpl;
import com.test.entities.Owner;
import com.test.utils.HibernateUtils;

public class AddOwner
{
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			
			// create team dao instance
			OwnerDao tDao=new OwnerDaoImpl();
			System.out.print("Enter owner name : ");
			String oName = sc.nextLine();
			System.out.print("Enter email : ");
			String email = sc.next();
			System.out.print("Enter company name : ");
			String compamy = sc.nextLine();
			sc.next();
			System.out.print("Enter team id : ");
			Long teamId = sc.nextLong();
			
			Owner owner = new Owner(oName, email, compamy, 1);
			System.out.println(tDao.addOwner(teamId, owner));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
