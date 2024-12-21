package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class DisplayOnlyATeam 
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
				TeamDao tDao = new TeamDaoImpl();
				System.out.println("Enter team id : ");
				long teamId = sc.nextLong();
				Team team = tDao.displayTeamOnly(teamId);
				if(team != null)
					System.out.println(team);
				else
					System.out.println("Invalide team id..");
				
		}
	}

}
