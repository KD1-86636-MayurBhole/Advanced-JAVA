package com.test.testing;

import java.util.List;

import org.hibernate.SessionFactory;

import com.test.dao.TeamDao;
import com.test.dao.TeamDaoImpl;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class GetAllTeams 
{
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory()){
			TeamDao tDao = new TeamDaoImpl();
			List<Team> allTeams = tDao.getAllTeams();
			for (Team team : allTeams) {
				System.out.println(team);
			}
		
		}

	}

}
