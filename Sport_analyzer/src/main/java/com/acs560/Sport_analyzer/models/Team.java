package com.acs560.Sport_analyzer.models;

import java.util.Objects;

import com.acs560.Sport_analyzer.models.Team;
import com.opencsv.bean.CsvBindByPosition;

public class Team {
	@CsvBindByPosition(position = 0)
    public int year;
	@CsvBindByPosition(position = 1)
    public String name;
	@CsvBindByPosition(position = 2)
    public String league;
	@CsvBindByPosition(position = 3)
    public int wins;
	@CsvBindByPosition(position = 4)
    public int losses;
	@CsvBindByPosition(position = 5)
    public int points;

	// Default constructor (required for CSV parsing)
    public Team() {
    }

    
    public Team(int year, String name, String league, int wins, int losses, int points) {
        this.year = year;
        this.name = name;
        this.league = league;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return year == team.year && wins == team.wins && losses == team.losses && points == team.points && Objects.equals(name, team.name) && Objects.equals(league, team.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, name, league, wins, losses, points);
    }
}
