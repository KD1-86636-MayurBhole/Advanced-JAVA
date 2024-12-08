package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entities.Team;

public class addTeamTester {

	public static void main(String[] args) {
		try (SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in);){
					TeamDao tdao=new TeamDaoImpl();
					System.out.println("Enter player details : \n");
					System.out.print("Name           : ");
					String name=sc.next();
					System.out.print("Abbravation    : ");
					String abbravation=sc.next();
					System.out.print("Owner          :");
					String owner=sc.next();
					System.out.print("Age            :");
					int age=sc.nextInt();
					System.out.print("Batting Average:");
					double avg=sc.nextDouble();
					System.out.print("Wickets        :");
					int wkt=sc.nextInt();
					Team t=new Team(name,abbravation,owner,age,avg,wkt);
					System.out.print(tdao.addTeam(t));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}