package eecs285.proj4.FF;

import java.util.ArrayList;

public class Team {
  public String teamName;
  public boolean commissioner;
  private ArrayList<Player> players = new ArrayList<>();
  Team(String inName){
    teamName = inName;
  }
  public void addPlayer(Player inPlayer){
    players.add(inPlayer);
  }
  public ArrayList<Player> getPlayers(){
    return players;
  }
}
