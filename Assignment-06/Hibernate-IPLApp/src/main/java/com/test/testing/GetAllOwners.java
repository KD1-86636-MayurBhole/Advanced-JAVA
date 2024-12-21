package com.test.testing;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.test.dao.OwnerDao;
import com.test.dao.OwnerDaoImpl;
import com.test.entities.Owner;
import com.test.utils.HibernateUtils;

public class GetAllOwners {
	public static void main(String[] args) {
		try(SessionFactory factory = HibernateUtils.getSessionFactory()){
			
			OwnerDao dao = new OwnerDaoImpl();
			List<Owner> owners = dao.displayAllOwners();
			for (Owner owner : owners) {
				System.out.println(owner);
			}
		}
	}
}
