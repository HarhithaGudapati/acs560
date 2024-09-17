/*package com.acs560.Sport_analyzer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

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
    
    @PostMapping("/{name}")
    public ResponseEntity<Team> createTeam(@PathVariable String name, @RequestBody Team team) {
        Team existingTeam = teamService.getTeamByName(name);
        if (existingTeam != null) {
            return ResponseEntity.badRequest().build();
        }
        Team newTeam = teamService.updateTeam(team);
        return ResponseEntity.ok(newTeam);
    }
    
    @PutMapping("/{name}")
    public Team updateTeam(@PathVariable String name, @RequestBody Team team) {
        return teamService.updateTeam(team);
    }
    @DeleteMapping("/{name}")
    public  void deleteTeam(@PathVariable String name) {
        teamService.deleteTeam(name);
    }
} */

/*package com.acs560.Sport_analyzer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private TeamService teamService;

    
    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeam(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        return ResponseEntity.ok(team);
    }

    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok(teamService.getTeams());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Team>> getTeamsByYear(@PathVariable int year) {
        return ResponseEntity.ok(teamService.getTeamsByYear(year));
    }

    
    @GetMapping("/league/{league}")
    public ResponseEntity<List<Team>> getTeamsByLeague(@PathVariable String league) {
        return ResponseEntity.ok(teamService.getTeamsByLeague(league));
    }

    @GetMapping("/wins/{wins}")
    public ResponseEntity<List<Team>> getTeamsByWins(@PathVariable int wins) {
        return ResponseEntity.ok(teamService.getTeamsByWins(wins));
    }

   
    @GetMapping("/losses/{losses}")
    public ResponseEntity<List<Team>> getTeamsByLosses(@PathVariable int losses) {
        return ResponseEntity.ok(teamService.getTeamsByLosses(losses));
    }

    
    @GetMapping("/points/{points}")
    public ResponseEntity<List<Team>> getTeamsByPoints(@PathVariable int points) {
        return ResponseEntity.ok(teamService.getTeamsByPoints(points));
    }

    @PostMapping
    public ResponseEntity<Team> add(@RequestBody Team team) {
        ((TeamService) teamService).add(team);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Team> update(@RequestBody Team team) {
        teamService.updateTeam(team);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Team> delete(@PathVariable String name) {
        teamService.deleteTeam(name);
        return ResponseEntity.ok().build();
    }
} */


package com.acs560.Sport_analyzer.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamService;
import lombok.NoArgsConstructor;

/*@RestController
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
} */

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
