package com.test.dao;

import java.util.List;

import com.test.entities.Owner;

public interface OwnerDao 
{
	public String addOwner(Long teamId, Owner owner);
	public String deleteOwner(Long ownerId);
	
	public List<Owner>displayAllOwners();

}
