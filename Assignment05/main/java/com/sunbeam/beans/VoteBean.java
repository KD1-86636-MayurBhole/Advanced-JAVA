package com.sunbeam.beans;

import javax.servlet.ServletException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	private int candId;
	private int userId;
	private boolean sucess;
	public VoteBean()
	{
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean getSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	public void vote() throws ServletException
	{
		sucess=false;
		try (CandidateDao canDao =new CandidateDaoImpl()) {
			int count = canDao.incrVote(this.candId);
			if(count == 1) {
				try(UserDao userDao = new UserDaoImpl()) {
					User user = userDao.findById(this.userId);
					if(user != null) {
						user.setStatus(1);
						count = userDao.update(user);
						if(count == 1)
							this.sucess = true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
