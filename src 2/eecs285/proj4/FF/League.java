package eecs285.proj4.FF;

import java.util.ArrayList;

public class League {
  public String leagueName;
  private ArrayList<Team> teamList = new ArrayList<>();
  League(String inName){
    leagueName = inName;
  }
  public void addteam(Team inTeam){
    teamList.add(inTeam);
  }
  public ArrayList<Team> getTeams(){
    return teamList;
  }
}
