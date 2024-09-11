package com.acs560.Sport_analyzer.services;


public interface TeamAnalysisService {

    double getMeanWins();

    double getMedianWins();

    int getModeWins();

    double getAverageWinsByLeague(String league);

    double getAverageWinsByLeagueAndYear(String league, int year);

	void analyzeTeams();
}