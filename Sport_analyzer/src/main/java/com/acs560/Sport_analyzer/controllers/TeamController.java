package com.acs560.Sport_analyzer.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamService;


@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamService.getTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeamByName(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(team);
    }
    
    // 3 additional functional requirements added
    
    @GetMapping("/{startYear}/{endYear}")
    public ResponseEntity<List<Team>> getTeamsByYearRange(@PathVariable int startYear, @PathVariable int endYear) {
        List<Team> teams = teamService.getTeamsByYearRange(startYear, endYear);
        if (teams.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teams);
    }
    
    @GetMapping("/top/{count}")
    public ResponseEntity<List<Team>> getTopTeamsByWins(@PathVariable int count) {
        List<Team> topTeams = teamService.getTopTeamsByWins(count);
        if (topTeams.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topTeams);
    }
    
    @GetMapping("/compare")
    public ResponseEntity<Map<String, Object>> compareTeams(
            @RequestParam String team1, 
            @RequestParam String team2) {
        try {
            Map<String, Object> comparison = teamService.compareTeams(team1, team2);
            return ResponseEntity.ok(comparison);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @PostMapping
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        if (teamService.addTeam(team)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(team);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        if (teamService.updateTeam(team)) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        if (teamService.deleteTeam(team)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
