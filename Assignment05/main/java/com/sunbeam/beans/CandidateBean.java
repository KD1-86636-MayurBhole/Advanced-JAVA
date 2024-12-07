package com.sunbeam.beans;

import java.util.List;

import javax.servlet.ServletException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidateBean {
	private List<Candidate> candlist;
	public CandidateBean()
	{}
	public List<Candidate> getCandlist() {
		return candlist;
	}
	public void setCandlist(List<Candidate> candlist) {
		this.candlist = candlist;
	}
	public void fetchCandidate() throws ServletException {
		try(CandidateDao canDao=new CandidateDaoImpl())
		{
			candlist=canDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
