/*package com.acs560.Sport_analyzer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.models.Team;

@Service

public interface TeamService {

    List<Team> getTeams();

    Team getTeamByName(String name);
    List<Team> getTeamsByYear(int year);

    List<Team> getTeamsByLeague(String league);
    List<Team> getTeamsByWins(int wins);

    List<Team> getTeamsByLosses(int losses);

    List<Team> getTeamsByPoints(int points);

	void addTeam(Team team);

	void deleteTeam(Team team);

	List<Team> getTeams(String league);
	void updateTeam(Team team);
	
}
*/

package com.acs560.Sport_analyzer.services;

import java.util.List;

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
	
	

 
}
