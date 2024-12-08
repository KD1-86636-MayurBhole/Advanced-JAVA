package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Team;

public interface TeamDao {
	String addTeam(Team team);
	List<Team> getTeams();
	List<Team> getTeamsOnBattingAvg(int age, double avg);
	List<Team> getTeamsOwnersNAbbravations(int age , double avg);
	String updateAge(String abbravation,int age);
	String deleteTeam(Long id);
}
