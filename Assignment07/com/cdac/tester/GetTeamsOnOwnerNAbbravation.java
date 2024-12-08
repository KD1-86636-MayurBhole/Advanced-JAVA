package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class GetTeamsOnOwnerNAbbravation {

	public static void main(String[] args) {
		try (SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			TeamDao tdao=new TeamDaoImpl();
			System.out.print("Enter the Age : ");
			int age=sc.nextInt();
			System.out.print("Enter the Average : ");
			double avg=sc.nextInt();
			tdao.getTeamsOwnersNAbbravations(age,avg).forEach(System.out::println);		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
