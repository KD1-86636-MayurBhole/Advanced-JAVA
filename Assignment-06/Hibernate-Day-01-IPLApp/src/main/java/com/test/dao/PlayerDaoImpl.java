package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.entities.Player;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

import lombok.Getter;

@Getter
public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Long teamId, Player player) {
		String mesg = "adding player failed.. No team id matched..";
		// 1. Get Session from SF
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get category from it's id
			Team team = session.get(Team.class, teamId);
			// 4 . null checking
			if (team != null) {
				// => player : persistent
				// 5. Establish bi dir association between entities
				/*
				 * add a player ref in the List set team ref to the player
				 */
				team.addPlayer(player);
//				session.persist(player);	//cascade will automatically save 		
				mesg = "added new player...";
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	
	
	@Override
	public String deletePlayer(Long playerId, Long TeamId) {
		String mesg = "removing player failed";

		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get categroy from its id
			Player player = session.get(Player.class, playerId);
			// 4. get blog from its id
			Team team = session.get(Team.class, TeamId);
			// 5 null checking
			if (player != null && team != null) {
				// category , post - persistent
				team.removePlayer(player);
				mesg = "deleted player";

			}
			tx.commit();// DML -
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}
