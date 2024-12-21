package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.utils.HibernateUtils;

public class UpdateTeamByName {
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
				TeamDao tDao = new TeamDaoImpl();
				System.out.println("Enter Team name : ");
				String msg = tDao.updateTeamMaxAge(sc.nextLine());
				System.out.println(msg);
		}
	}
}
