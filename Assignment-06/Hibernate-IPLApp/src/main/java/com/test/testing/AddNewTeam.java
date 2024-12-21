package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class AddNewTeam {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			
			// create team dao instance
			TeamDao tDao=new TeamDaoImpl();
			System.out.print("Enter team name : ");
			String tName = sc.nextLine();
			System.out.print("Enter team abbreviation : ");
			String tAbbreviation = sc.next();
			System.out.print("Enter maximum player age : ");
			int age = sc.nextInt();
			System.out.print("Enter player batting avg : ");
			double battingAvg = sc.nextDouble();
			System.out.print("Enter how many wicket taken by player : ");
			int noOfWickets = sc.nextInt();
			
			Team team = new Team(tName, tAbbreviation, age, battingAvg, noOfWickets);
			
			System.out.println(tDao.addNewTeam(team));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}