package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class DisplayTeamAndPlayerDetails 
{
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			TeamDao tDao = new TeamDaoImpl();
			System.out.println("Enter category id to search");			
			Team team=tDao.displayTeamAndPlayerDetails(sc.nextLong());
			System.out.println(team);
			System.out.println("All posts - ");
			team.getPlayers().
			forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
