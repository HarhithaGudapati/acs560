package com.acs560.Sport_analyzer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamService;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/v1/teams")
@NoArgsConstructor

public class TeamController {

    @Autowired
    public TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }
    
//    @GetMapping{"/test"}
//    public String getTeams1() {
//        return "Hi";
//    }

    @GetMapping("/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }
   
    
    @GetMapping("/year/{year}")
    public List<Team> getTeamsByYear(@PathVariable int year) {
        return teamService.getTeamsByYear(year);
    }

    @GetMapping("/league/{league}")
    public List<Team> getTeamsByLeague(@PathVariable String league) {
        return teamService.getTeamsByLeague(league);
    }
    
    @GetMapping("/wins/{wins}")
    public List<Team> getTeamsByWins(@PathVariable int wins) {
        return teamService.getTeamsByWins(wins);
    }

    @GetMapping("/losses/{losses}")
    public List<Team> getTeamsByLosses(@PathVariable int losses) {
        return teamService.getTeamsByLosses(losses);
    }

    @GetMapping("/points/{points}")
    public List<Team> getTeamsByPoints(@PathVariable int points) {
        return teamService.getTeamsByPoints(points);
    }
}