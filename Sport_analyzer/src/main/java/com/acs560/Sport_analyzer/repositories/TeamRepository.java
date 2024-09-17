/*package com.acs560.Sport_analyzer.repositories;
	
	import com.opencsv.bean.CsvToBean;
	import com.opencsv.bean.CsvToBeanBuilder;
	import org.springframework.core.io.ClassPathResource;
	import org.springframework.stereotype.Repository;
	
	import com.acs560.Sport_analyzer.models.Team;
	
	import java.io.BufferedReader;
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
	    
	   
	}
*/


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

import com.acs560.Sport_analyzer.exception.TeamRepositoryManagementException;
import com.acs560.Sport_analyzer.models.Team;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*@Repository
public class TeamRepository {

    private static List<Team> teams;

    static {
        if (teams == null) {
            teams = initializeTeams();
        }
    }

   
    public static List<Team> getTeams() {
        return teams;
    }

   
    private static List<Team> initializeTeams() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new ClassPathResource("sports_data.csv").getInputStream()))) {

            CsvToBean<Team> csvToBean = new CsvToBeanBuilder<Team>(bufferedReader)
                    .withType(Team.class)
                    .withSkipLines(1) // Skip header line
                    .build();

            teams = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            teams = new ArrayList<>();
        }

        return teams;
    }

   
    public static void addTeam(Team team) {
        if (teams.contains(team)) {
            throw new IllegalArgumentException("Error adding team - team already exists");
        }

        if (saveTeam(team)) {
            teams.add(team);
        } else {
            throw new TeamRepositoryManagementException("Error adding team");
        }
    }

    
    public static void updateTeam(Team team) {
        int index = teams.indexOf(team);

        if (index == -1) {
            throw new IllegalArgumentException("Error updating team - team does not exist");
        }

        Team backup = teams.get(index);
        teams.set(index, team);

        if (!saveTeams()) {
            teams.set(index, backup);
            throw new TeamRepositoryManagementException("Error updating team");
        }
    }

   
    public static void deleteTeam(Team team) {
        if (!teams.remove(team)) {
            throw new IllegalArgumentException("Error deleting team - team does not exist");
        }

        if (!saveTeams()) {
            teams.add(team);
            throw new TeamRepositoryManagementException("Error deleting team");
        }
    }

    
    private static StatefulBeanToCsv<Team> createWriter(FileWriter writer) {
        return new StatefulBeanToCsvBuilder<Team>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();
    }

    
    private static boolean saveTeam(Team team) {
        boolean isSaved = false;

        try (FileWriter writer = new FileWriter("sports_data.csv", true)) {
            StatefulBeanToCsv<Team> beanWriter = createWriter(writer);
            beanWriter.write(team);
            isSaved = true;
        } catch ( IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
        	System.err.println(( e).getMessage());
		}

        return isSaved;
    }

    
    private static boolean saveTeams() {
        boolean isSaved = false;

        try (FileWriter writer = new FileWriter("sports_data.csv")) {
            StatefulBeanToCsv<Team> beanWriter = createWriter(writer);
            beanWriter.write(teams);
            isSaved = true;
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			System.err.println(e.getMessage());
		}

        return isSaved;
    }
} */

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







