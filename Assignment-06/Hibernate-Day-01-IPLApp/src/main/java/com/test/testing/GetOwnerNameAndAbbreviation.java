package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.utils.HibernateUtils;

public class GetOwnerNameAndAbbreviation 
{
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao tDao = new TeamDaoImpl();
			System.out.println("Enter max age : ");
			int age = sc.nextInt();
			System.out.println("Enter batting avg : ");
			double average = sc.nextDouble();
			
//			tDao.displayOwnerNameAndAbbreviations(age, average).forEach(t->System.out.println(t.getOwner() + "\t" + t.getAbbreviation()));
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
