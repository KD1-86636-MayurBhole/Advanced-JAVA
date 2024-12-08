package com.cdac.dao;
import org.hibernate.*;

import com.cdac.entities.Team;

import java.io.Serializable;
import java.util.List;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class TeamDaoImpl implements TeamDao{

	@Override
	public String addTeam(Team team) {
		String msg="Team inserted succesfully";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable Id=session.save(team);
			tx.commit();
			msg="Team Added ! , ID "+Id;
		}catch(RuntimeException r)
		{
			if(tx != null)
				tx.rollback();
			throw r;
		}
		return null;
	}

	@Override
	public List<Team> getTeams() {
		Session session=getSessionFactory().getCurrentSession();
		String query="select t from Team t";
		List<Team> teams=null;
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(query, Team.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException r){
			if(tx != null)
			{
				tx.rollback();
			throw r;
			}
		}
		return teams;
	}

	@Override
	public List<Team> getTeamsOnBattingAvg(int  age,double avg) {
		Session session=getSessionFactory().getCurrentSession();
		String query="select t from Team t where t.battingAverage>:av and t.age<:ag";
		List<Team> teams=null;
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(query, Team.class).setParameter("av", avg).setParameter("ag", age).getResultList();
			tx.commit();
		}
		catch(RuntimeException r){
			if(tx != null)
			{
				tx.rollback();
			throw r;
			}
		}
		return teams;
	}

	@Override
	public List<Team> getTeamsOwnersNAbbravations(int age, double avg) {
		Session session=getSessionFactory().getCurrentSession();
		String query="select new com.cdac.entities.Team(owner,abbravation) from Team t where t.battingAverage>:av and t.age<:ag";
		List<Team> teams=null;
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(query, Team.class).setParameter("av", avg).setParameter("ag", age).getResultList();
			tx.commit();
		}
		catch(RuntimeException r){
			if(tx != null)
			{
				tx.rollback();
			throw r;
			}
		}
		return teams;
	}

	@Override
	public String updateAge(String abbravation,int age) {
		Session session=getSessionFactory().getCurrentSession();
		String query="select t from Team t where abbravation=:ab";
		String msg="Updation faild";
		Transaction tx=session.beginTransaction();
		try {
			Team team=session.createQuery(query, Team.class).setParameter("ab", abbravation).getSingleResult();
			if(team!=null)
				msg="age updated succesfully";
			team.setAge(age);
			tx.commit();
		}
		catch(RuntimeException r){
			if(tx != null)
			{
				tx.rollback();
			}
		}
		return msg;
	}

	@Override
	public String deleteTeam(Long id) {
		Session session=getSessionFactory().getCurrentSession();
		String msg="Deletion failed";
		Team team=null;
		Transaction tx=session.beginTransaction();
		try {
			 team=session.get(Team.class, id);
			if(team!=null)
				msg="Team deleted succesfully";
			session.delete(team);
			tx.commit();
		}
		catch(RuntimeException r){
			if(tx != null)
			{
				tx.rollback(); 
			}
		}
		return msg;
	}
	
}
