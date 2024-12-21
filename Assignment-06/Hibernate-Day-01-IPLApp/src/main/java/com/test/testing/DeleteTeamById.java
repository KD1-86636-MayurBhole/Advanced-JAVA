package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.utils.HibernateUtils;

public class DeleteTeamById 
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
				TeamDao tDao = new TeamDaoImpl();
				System.out.print("Enter id to delete : ");
				String msg = tDao.deleteTeam(sc.nextLong());
				System.out.println("Message : " + msg);
		}
	}

}
