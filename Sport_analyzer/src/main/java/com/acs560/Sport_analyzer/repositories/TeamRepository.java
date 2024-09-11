package com.acs560.Sport_analyzer.repositories;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import com.acs560.Sport_analyzer.models.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class TeamRepository {

    private static List<Team> teams;

    private static void initializeTeams() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new ClassPathResource("sports_data.csv").getInputStream()))) {

            String firstLine = bufferedReader.readLine();
            if (firstLine != null && firstLine.startsWith("\uFEFF")) {
                firstLine = firstLine.substring(1);
            }

//            StringBuilder stringBuilder = new StringBuilder(firstLine);
//            bufferedReader.lines().forEach(stringBuilder::append);
//            StringReader stringReader = new StringReader(stringBuilder.toString());

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

    public static List<Team> getTeams() {
    	if (teams == null) {
    		initializeTeams();
    		teams.add(new Team(0, null, null, 0, 0, 0));
    	}
    	
        return teams;
    }


}




