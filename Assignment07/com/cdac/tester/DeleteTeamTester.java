package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class DeleteTeamTester {

	public static void main(String[] args) {
		try (SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			TeamDao tdao=new TeamDaoImpl();
			System.out.print("Enter Team id to delete : ");
			Long id=sc.nextLong();
			System.out.println(tdao.deleteTeam(id));		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
