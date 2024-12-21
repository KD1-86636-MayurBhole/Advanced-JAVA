package com.test.testing;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class DisplayAllTeamsOnBattingAvgAndAge 
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
				TeamDao tDao = new TeamDaoImpl();
				System.out.println("Enter max age : ");
				int age = sc.nextInt();
				System.out.println("Enter batting avg : ");
				double average = sc.nextDouble();
				List<Team> teams = tDao.displayAgeAndBattingAvg(age, average);
				for (Team team : teams) {
					System.out.println(team);
				}
		}
	}

}
