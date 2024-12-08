package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class getAllTeams {
	public static void main(String args[])
	{
		try (SessionFactory sf=getSessionFactory()){
			TeamDao tdao=new TeamDaoImpl();
			tdao.getTeams().forEach(System.out::println);		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
