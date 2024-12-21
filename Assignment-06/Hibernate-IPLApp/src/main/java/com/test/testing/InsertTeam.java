package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class InsertTeam
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
			Scanner sc=new Scanner(System.in)){
			
			TeamDao tDao = new TeamDaoImpl();

			System.out.print("Enter team name : ");
			String tName = sc.nextLine();
//			sc.next();
			System.out.print("Enter team abbreviation : ");
			String tAbbreviation = sc.next();
			System.out.print("Enter team owner name : ");
			String tOwnerName = sc.next();
			System.out.print("Enter maximum player age : ");
			int age = sc.nextInt();
			System.out.print("Enter player batting avg : ");
			double battingAvg = sc.nextDouble();
			System.out.print("Enter how many wicket taken by player : ");
			int noOfWickets = sc.nextInt();
			
//			Team team = new Team(tName, tAbbreviation, tOwnerName, age, battingAvg, noOfWickets);
//			String msg = tDao.saveTeam(team);
//			System.out.println(msg);
		}
	}

}
