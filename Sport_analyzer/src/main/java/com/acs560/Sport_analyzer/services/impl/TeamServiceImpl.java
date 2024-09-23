/*package com.acs560.Sport_analyzer.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.TeamRepository;
import com.acs560.Sport_analyzer.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Team> getTeamsByYear(int year) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLeague(String league) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getLeague() != null && team.getLeague().equalsIgnoreCase(league))
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByWins(int wins) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getWins() == wins)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLosses(int losses) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getLosses() == losses)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByPoints(int points) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getPoints() == points)
                .collect(Collectors.toList());
    }

	@Override
	public Team createTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	@Override
	public Team updateTeam(String name, Team team) {
		Team existingTeam = getTeamByName(name);
        if (existingTeam != null) {
            existingTeam.setName(team.getName());
            existingTeam.setYear(team.getYear());
            existingTeam.setLeague(team.getLeague());
            existingTeam.setWins(team.getWins());
            existingTeam.setLosses(team.getLosses());
            existingTeam.setPoints(team.getPoints());
            return teamRepository.save(existingTeam);
        } else {
            return null;
        }
	}

	@Override
	public void deleteTeam(String name) {
		// TODO Auto-generated method stub
		Team team = getTeamByName(name);
        if (team != null) {
            teamRepository.deleteTeam(name);
        }
	}
}
*/

/*package com.acs560.Sport_analyzer.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.TeamRepository;

import sports.acs560.performance_analyzer.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    

    @Override
    public List<Team> getTeams() {
        List<Team> teams = TeamRepository.getTeams();
        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public List<Team> getTeams(String name) {
        List<Team> filteredTeams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getLeague() != null && t.getLeague().equalsIgnoreCase(name))
                .toList());

        if (filteredTeams.isEmpty()) {
            throw new NoSuchElementException();
        }

        filteredTeams.sort(createTeamComparator());
        return filteredTeams;
    }
    
    private Comparator<Team> createTeamComparator() {
        return Comparator.comparing(Team::getYear)
                .thenComparing(Team::getLeague)
                .thenComparing(Team::getName);
    }

    @Override
    public Team getTeam(String name, int year) {
        Team team = TeamRepository.getTeams()
                .stream()
                .filter(t -> t.equals(new Team(name, year)))
                .findAny()
                .orElseThrow();

        return team;
    }

    @Override
    public List<Team> getTeams(String name, int year) {
        List<Team> filteredTeams = new ArrayList<>(TeamRepository.getTeams()
                .stream()
                .filter(t -> t.getLeague().equals(name) && t.getYear() == year)
                .toList());

        if (filteredTeams.isEmpty()) {
            throw new NoSuchElementException();
        }

        filteredTeams.sort(createTeamComparator());
        return filteredTeams;
    }



  
    
    
    
    @Override
    public List<Team> getTeamsByYear(int year) {
        List<Team> teams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getYear() == year)
                .toList());

        if (teams.isEmpty()) {
            throw new NoSuchElementException();
        }

        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public void add(Team team) {
        TeamRepository.addTeam(team);
    }

    @Override
    public void update(Team team) {
        TeamRepository.updateTeam(team);
    }
    
    @Override
    public void delete(Team team) {
        TeamRepository.deleteTeam(team);
    }

    @Override
    public List<Team> getTeamsByWins(int wins) {
        List<Team> teams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getWins() == wins)
                .toList());

        if (teams.isEmpty()) {
            throw new NoSuchElementException();
        }

        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public List<Team> getTeamsByLeague(String league) {
        List<Team> teams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getLeague().equals(league))
                .toList());

        if (teams.isEmpty()) {
            throw new NoSuchElementException();
        }

        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public List<Team> getTeamsByPoints(int points) {
        List<Team> teams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getPoints() == points)
                .toList());

        if (teams.isEmpty()) {
            throw new NoSuchElementException();
        }

        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public List<Team> getTeamsByLosses(int losses) {
        List<Team> teams = new ArrayList<>(TeamRepository.getTeams().stream()
                .filter(t -> t.getLosses() == losses)
                .toList());

        if (teams.isEmpty()) {
            throw new NoSuchElementException();
        }

        teams.sort(createTeamComparator());
        return teams;
    }

    @Override
    public Team getTeamByName(String name) {
        Team team = TeamRepository.getTeams().stream()
                .filter(t -> t.getName().equals(name))
                .findFirst()
                .orElseThrow();

        return team;
    }

} */

package com.acs560.Sport_analyzer.services.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.TeamRepository;
import com.acs560.Sport_analyzer.services.TeamService;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Team> getTeamsByYear(int year) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLeague(String league) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getLeague() != null && team.getLeague().equalsIgnoreCase(league))
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByWins(int wins) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getWins() == wins)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByLosses(int losses) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getLosses() == losses)
                .collect(Collectors.toList());
    }

    @Override
    public List<Team> getTeamsByPoints(int points) {
        return teamRepository.getTeams().stream()
                .filter(team -> team.getPoints() == points)
                .collect(Collectors.toList());
    }
   


    @Override
    public boolean addTeam(Team team) {
        return teamRepository.addTeam(team);
    }

    @Override
    public boolean updateTeam(Team team) {
        return teamRepository.updateTeam(team);
    }

    @Override
    public boolean deleteTeam(Team team) {
        return teamRepository.deleteTeam(team);
    }

	@Override
	public List<Team> getTeams(String league) {
		return null;
		// TODO Auto-generated method stub
		    
	}
	
	
	
	
	
	
	
	// new functional requirements added 

	@Override
	public List<Team> getTeamsByYearRange(int startYear, int endYear) {
		// TODO Auto-generated method stub
		return teamRepository.getTeams().stream()
		        .filter(t -> t.getYear() >= startYear && t.getYear() <= endYear)
		        .collect(Collectors.toList());
	}

	@Override
	public List<Team> getTopTeamsByWins(int count) {
	    return teamRepository.getTeams().stream() // Get all teams
	            .sorted(Comparator.comparingInt(Team::getWins).reversed()) // Sort by wins in descending order
	            .limit(count) // Limit to the specified count
	            .collect(Collectors.toList()); // Collect the results into a list
	}
	
	 @Override
	    public Map<String, Object> compareTeams(String teamName1, String teamName2) {
	        Team team1 = getTeamByName(teamName1);
	        Team team2 = getTeamByName(teamName2);

	        if (team1 == null || team2 == null) {
	            throw new IllegalArgumentException("One or both teams not found");
	        }

	        Map<String, Object> comparisonResult = new HashMap<>();
	        comparisonResult.put("team1Name", team1.getName());
	        comparisonResult.put("team2Name", team2.getName());

	        // Compare wins
	        comparisonResult.put("team1Wins", team1.getWins());
	        comparisonResult.put("team2Wins", team2.getWins());
	        comparisonResult.put("winsComparison", Integer.compare(team1.getWins(), team2.getWins()));

	        // Compare losses
	        comparisonResult.put("team1Losses", team1.getLosses());
	        comparisonResult.put("team2Losses", team2.getLosses());
	        comparisonResult.put("lossesComparison", Integer.compare(team1.getLosses(), team2.getLosses()));

	        // Compare points
	        comparisonResult.put("team1Points", team1.getPoints());
	        comparisonResult.put("team2Points", team2.getPoints());
	        comparisonResult.put("pointsComparison", Integer.compare(team1.getPoints(), team2.getPoints()));

	        return comparisonResult;
	    }

}
