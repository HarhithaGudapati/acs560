package com.acs560.Sport_analyzer.services.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamAnalysisService;
import com.acs560.Sport_analyzer.repositories.TeamRepository;

@Service
public class TeamAnalysisServiceImpl implements TeamAnalysisService {




    
    @Override
    public double getMeanWins() {
        List<Team> teams = TeamRepository.getTeams();
        return teams.stream()
                .mapToInt(Team::getWins)
                .average()
                .orElse(0);  
    }

    
    @Override
    public double getMedianWins() {
        List<Team> teams = TeamRepository.getTeams();
        List<Integer> wins = teams.stream()
                .map(Team::getWins)
                .sorted()
                .collect(Collectors.toList());
        
        int size = wins.size();
        if (size == 0) return 0;  
        
        if (size % 2 == 0) {
            return (wins.get(size / 2 - 1) + wins.get(size / 2)) / 2.0;
        } else {
            return wins.get(size / 2);
        }
    }

   
    @Override
    public int getModeWins() {
        List<Team> teams = TeamRepository.getTeams();
        Map<Integer, Long> frequencyMap = teams.stream()
                .collect(Collectors.groupingBy(Team::getWins, Collectors.counting()));
        
        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())  
                .map(Map.Entry::getKey)
                .orElse(0);  
    }

    @Override
    public double getAverageWinsByLeague(String league) {
        List<Team> teamsByLeague = TeamRepository.getTeams().stream()
                .filter(team -> team.getLeague().equalsIgnoreCase(league))
                .collect(Collectors.toList());
        
        return teamsByLeague.stream()
                .mapToInt(Team::getWins)
                .average()
                .orElse(0);
    }

    @Override
    public double getAverageWinsByLeagueAndYear(String league, int year) {
        List<Team> teamsByLeagueAndYear = TeamRepository.getTeams().stream()
                .filter(team -> team.getLeague().equalsIgnoreCase(league) && team.getYear() == year)
                .collect(Collectors.toList());
        
        return teamsByLeagueAndYear.stream()
                .mapToInt(Team::getWins)
                .average()
                .orElse(0);
    }

    
    @Override
    public void analyzeTeams() {
       
  	
        System.out.println("Analyzing teams..");
        
        double meanWins = getMeanWins();
        System.out.println("Mean Wins: " + meanWins);

        double medianWins = getMedianWins();
        System.out.println("Median Wins: " + medianWins);

        int modeWins = getModeWins();
        System.out.println("Mode Wins: " + modeWins);

        String league = "Premier League"; 
        double averageWinsPremierLeague = getAverageWinsByLeague(league);
        System.out.println("Average Wins in " + league + ": " + averageWinsPremierLeague);

        int year = 2020;
        double averageWinsPremierLeague2020 = getAverageWinsByLeagueAndYear(league, year);
        System.out.println("Average Wins in " + league + " in " + year + ": " + averageWinsPremierLeague2020);
    }
}

