package com.test.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.test.entities.Player;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String saveTeam(Team team) {
		String mesg = "Team is not successfully inserted.";
		// 1. Get Session from SessionFactory
		/*
		 * Method of SessionFactory public Session getCurrentSession() throws
		 * HibernateException
		 */
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();

		// 2 . Begin a Transaction
		/*
		 * Method of Session public Transaction beginTransaction() throws
		 * HibernateException
		 */
		Transaction tx = session.beginTransaction();
		try {
			/*
			 * Session API public Serializable save(Object transientEntity) throws
			 * HibernateException
			 */

			Serializable teamId = session.save(team);
			// => success
			tx.commit();
			mesg = "Team inserted successfully... ! , ID = " + teamId;
		} catch (RuntimeException e) {
			// => failure -> rollback the Tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return mesg;

	}

	@Override
	public List<Team> getAllTeams() {

		List<Team> teams = null;
		String jpql = "select t from Team t";
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return teams;
	}

	public List<Team> displayAgeAndBattingAvg(int age, double avg) {
		List<Team> teams = null;
		String jpql = "select t from Team t where t.maxPlayerAge<:age and t.battingAvg>:average";
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("average", avg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;
	}

	@Override
	public List<Team> displayOwnerNameAndAbbreviations(int age, double avg) {
		List<Team> teams = null;
		String jpql = "select new com.test.entities.Team(owner,abbreviation) from Team t where t.maxPlayerAge<:age and t.battingAvg>:average";
		// 1. get Session from SessionFactory
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("average", avg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;
	}

	@Override
	public String updateTeamMaxAge(String teamName) {
		String msg = "team updation failed..";
		String jpqlString = "select t from Team t where t.teamName=:tName";
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.createQuery(jpqlString, Team.class).setParameter("tName", teamName).getSingleResult();
			team.setMaxPlayerAge(40);
			msg = "team updated successfully..";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteTeam(Long teamId) {
		String msg = "team deletion operation failed...";
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				session.delete(team);
				msg = "team deleted successfully...";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String addNewTeam(Team team) {
		String mesg = "adding category failed!!!";
		// 1. Get Session from SF
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			mesg = "added new team with id=" + team.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public Team displayTeamAndPlayerDetails(Long teamId) {
		Team team = null;
		String jpql = "select t from Team t left join fetch t.players where t.id=:Id";
		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Transaction
		Transaction tx = session.beginTransaction();
		try {
			team = session.createQuery(jpql, Team.class).setParameter("Id", teamId).getSingleResult();// select
																										// -
																										// players
			// team - persistent
			// access un fetched data(proxy) from within session scope , before commit
			team.getPlayers();// select - players
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return team;// detached

	}

	@Override
	public Team displayTeamOnly(Long teamId) {
		Team team = null;
		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Transaction
		Transaction tx = session.beginTransaction();
		try {
			 team = session.get(Team.class, teamId);																	// -
			if(team != null) 
				return team;
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return team;// detached
	}

}
