package com.test.testing;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.PlayerDao;
import com.test.dao.PlayerDaoImpl;
import com.test.utils.HibernateUtils;

public class RemovePlayer 
{
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			PlayerDao dao=new PlayerDaoImpl();
			System.out.println("Enter player id and team id");			
			System.out.println(dao.deletePlayer(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
