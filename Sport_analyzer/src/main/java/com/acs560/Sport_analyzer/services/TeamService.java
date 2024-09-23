package com.acs560.Sport_analyzer.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.models.Team;

@Service
public interface TeamService {

    List<Team> getTeams();

    List<Team> getTeams(String league);

    Team getTeamByName(String name);

    List<Team> getTeamsByYear(int year);

    List<Team> getTeamsByLeague(String league);

    List<Team> getTeamsByWins(int wins);

    List<Team> getTeamsByLosses(int losses);

    List<Team> getTeamsByPoints(int points);

	boolean addTeam(Team team);

	boolean updateTeam(Team team);

	boolean deleteTeam(Team team);
	
	//3 additional functional requirements
	List<Team> getTeamsByYearRange(int startYear, int endYear);
	List<Team> getTopTeamsByWins(int count);
	Map<String, Object> compareTeams(String teamName1, String teamName2);


	

 
}
