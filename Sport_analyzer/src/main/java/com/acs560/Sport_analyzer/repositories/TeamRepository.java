package com.acs560.Sport_analyzer.repositories;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.acs560.Sport_analyzer.models.Team;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TeamRepository {

    private List<Team> teams;

    public TeamRepository() {
        initializeTeams();
    }

    private void initializeTeams() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new ClassPathResource("sports_data.csv").getInputStream()))) {

            CsvToBean<Team> csvToBean = new CsvToBeanBuilder<Team>(bufferedReader)
                .withType(Team.class)
                .withSkipLines(1)
                .build();

            teams = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            teams = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            teams = new ArrayList<>();
        }
    }

    public List<Team> getTeams() {
        return teams;
    }



    public boolean saveToCSV(List<Team> teams, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sports_data.csv", append))) {
            for (Team team : teams) {
                writer.write(team.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public  boolean addTeam(Team team) {
        if (teams.contains(team)) {
            return false;
        }
        teams.add(team);
        return saveToCSV(teams, false);
    }

    public boolean updateTeam(Team team) {
        int index = teams.indexOf(team);
        if (index == -1) {
            return false;
        }
        teams.set(index, team);
        return saveToCSV(teams, false);
    }

    public boolean deleteTeam(Team team) {
        if (!teams.remove(team)) {
            return false;
        }
        return saveToCSV(teams, false);
    }
}







