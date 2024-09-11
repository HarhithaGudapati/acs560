package com.acs560.Sport_analyzer.services;

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
}