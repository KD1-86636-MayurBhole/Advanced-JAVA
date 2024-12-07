package com.sunbeam.beans;

import javax.servlet.ServletException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteBean {
	private int candId;
	;private int result;
	public DeleteBean()
	{
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public void delete() throws ServletException
	{
		try(CandidateDao canDao=new CandidateDaoImpl())
		{
			int count=canDao.deleteById(candId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
