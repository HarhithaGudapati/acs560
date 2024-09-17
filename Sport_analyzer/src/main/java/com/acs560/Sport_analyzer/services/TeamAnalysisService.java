package com.acs560.Sport_analyzer.services;

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

	boolean addTeam(com.acs560.Sport_analyzer.models.Team team);

	boolean updateTeam(com.acs560.Sport_analyzer.models.Team team);

	boolean deleteTeam(com.acs560.Sport_analyzer.models.Team team);
	
	
	
	
	
}