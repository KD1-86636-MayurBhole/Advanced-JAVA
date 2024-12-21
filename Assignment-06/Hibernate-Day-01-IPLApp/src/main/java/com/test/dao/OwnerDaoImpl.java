package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.entities.Owner;
import com.test.entities.Team;
import com.test.utils.HibernateUtils;

public class OwnerDaoImpl implements OwnerDao {

	@Override
	public String addOwner(Long teamId, Owner owner) {
		String mesg = "adding owner failed.. No team id matched..";
		// 1. Get Session from SF
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get team from it's id
			Team team = session.get(Team.class, teamId);
			// 4 . null checking
			if (team != null) {

				session.persist(owner);
				owner.setTeamId(team);

				mesg = "added new Owner...";
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
	public String deleteOwner(Long ownerId) {
		String mesg = "removing owner failed";

		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();

		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get owner from its id
			Owner owner = session.get(Owner.class, ownerId);

			// 4 null checking
			if (owner != null) {
				owner.setStatus(0);
				mesg = "deleted owner successfully..";

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

	@Override
	public List<Owner> displayAllOwners() {
		int st = 1;
		String jpql = "select o from Owner o where o.status=:stat";
		List<Owner> owners = new ArrayList();
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			owners = session.createQuery(jpql, Owner.class).setParameter("stat", st).getResultList();
			//owners.size();
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return owners;
	}

}
