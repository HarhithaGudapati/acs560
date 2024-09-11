package com.acs560.Sport_analyzer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.services.TeamAnalysisService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/v1/analysis")
@NoArgsConstructor
public class TeamAnslysisController {

    
    public TeamAnalysisService teamAnalysisService;
    @Autowired
    public TeamAnslysisController(TeamAnalysisService teamAnalysisService) {
        this.teamAnalysisService = teamAnalysisService;
    }

    @GetMapping("/mean/wins")
    public double getMeanWins() {
        return teamAnalysisService.getMeanWins();
    }

    @GetMapping("/median/wins")
    public double getMedianWins() {
        return teamAnalysisService.getMedianWins();
    }

    @GetMapping("/mode/wins")
    public int getModeWins() {
        return teamAnalysisService.getModeWins();
    }

    @GetMapping("/average/wins/{league}")
    public double getAverageWinsByLeague(@PathVariable String league) {
        return teamAnalysisService.getAverageWinsByLeague(league);
    }

    @GetMapping("/average/wins/{league}/{year}")
    public double getAverageWinsByLeagueAndYear(@PathVariable String league, @PathVariable int year) {
        return teamAnalysisService.getAverageWinsByLeagueAndYear(league, year);
    }
}
