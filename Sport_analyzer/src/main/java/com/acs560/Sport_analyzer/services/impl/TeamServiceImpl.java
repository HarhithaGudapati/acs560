package com.acs560.Sport_analyzer.services.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

 import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.TeamRepository;
import com.acs560.Sport_analyzer.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	//TODO MCP get rid of this map...let the repository save all the data
    public Map<String, Team> teams;
    

//    @PostConstruct
//    public void init() {
//        teams = TeamRepository.getTeams().stream()
//                .collect(Collectors.toMap(Team::getName, Function.identity()));
//    }

    @Override
    public List<Team> getTeams() {
    	return TeamRepository.getTeams();
//        return new ArrayList<>(teams.values());
    }

    @Override
    public Team getTeamByName(String name) {
       return teams.get(name);	
               
    }
    
    @Override
    public List<Team> getTeamsByYear(int year) {
        return teams.values().stream()
                .filter(team -> team.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLeague(String league) {
        return teams.values().stream()
                .filter(team -> team.getLeague()!= null && team.getLeague().equalsIgnoreCase(league))
                		//.equals(league))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Team> getTeamsByWins(int wins) {
        return teams.values().stream()
                .filter(team -> team.getWins() == wins)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLosses(int losses) {
        return teams.values().stream()
                .filter(team -> team.getLosses() == losses)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByPoints(int points) {
        return teams.values().stream()
                .filter(team -> team.getPoints() == points)
                .collect(Collectors.toList());
    }
}
