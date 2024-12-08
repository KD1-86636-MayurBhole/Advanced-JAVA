package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class UpdateAge {

	public static void main(String[] args) {
		try (SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			TeamDao tdao=new TeamDaoImpl();
			System.out.print("Enter the Age to update : ");
			int age=sc.nextInt();
			System.out.print("Enter Team Abbravation  : ");
			String ab=sc.next();
			System.out.println(tdao.updateAge(ab,age));		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
