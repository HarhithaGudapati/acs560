package com.acs560.Sport_analyzer.services;

import java.util.List;

import sports.acs560.performance_analyzer.models.Team;

public interface TeamAnalysisService {

    double getMeanWins();

    double getMedianWins();

    int getModeWins();

    double getAverageWinsByLeague(String league);

    double getAverageWinsByLeagueAndYear(String league, int year);

	void analyzeTeams();

	boolean addTeam(Team team);

	boolean updateTeam(Team team);

	Team getTeamByName(String name);

	boolean deleteTeam(Team team);


	List<Team> getTeamsByYearRange(int startYear, int endYear);
	
	
	
}