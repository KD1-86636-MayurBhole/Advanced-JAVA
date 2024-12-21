package com.test.dao;

import java.util.List;

import com.test.entities.Team;

public interface TeamDao 
{
	
	//add new Team
	String addNewTeam(Team team);
	
	Team displayTeamAndPlayerDetails(Long teamId);
	
	Team displayTeamOnly(Long teamId);
	
	public String saveTeam(Team team);
	public List<Team> getAllTeams();
	public List<Team> displayAgeAndBattingAvg(int age, double avg);
	
	public List<Team> displayOwnerNameAndAbbreviations(int age, double avg);
	public String updateTeamMaxAge(String teamName);
	public String deleteTeam(Long teamId);

}
