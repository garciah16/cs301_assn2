package com.example.administrator.assignment2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

/**
 * Class SoccerTeam represents a soccer team,
 * keeps track of players and stats.
 * Created by garciah16 on 9/20/2015.
 */
public class SoccerTeam {

    private int wins;
    private int losses;
    private int draws;
    protected Hashtable<String,SoccerPlayer> playersTable;
    protected String teamName;

    //create an empty team
    public SoccerTeam(String team){
        wins = 0;
        losses = 0;
        draws = 0;
        playersTable = new Hashtable<String, SoccerPlayer>();
        teamName = team;
    }
//TODO: do i need this?
//    //create a team with a pre-made Hashtable that contains the players
//    public SoccerTeam(String team, Hashtable<String, SoccerPlayer> table){
//        wins = 0;
//        losses = 0;
//        draws = 0;
//        playersTable = table;
//        teamName = team;
//    }

    public int getWins(){
        return this.wins;
    }
    public void bumpWins(){
        this.wins++;
    }

    public int getLosses(){
        return this.losses;
    }
    public void bumpLosses(){
        this.losses++;
    }

    public int getDraws(){
        return this.draws;
    }
    public void bumpDraws(){
        this.draws++;
    }

    /**
     * put a new player into the team roster
     * @param player is a new player
     */
    public void addPlayer(SoccerPlayer player){
        playersTable.put(player.toString(), player);
    }

    public String printRoster(){
        //turn the hashtable into a collection in order to convert to an array
        Collection<SoccerPlayer> playerCollection = playersTable.values();
        SoccerPlayer[] playerArray = playerCollection.toArray(new SoccerPlayer[playerCollection.size()]);
        //turn the array of players into a printable string for viewing on screen
        String playerRoster = "";
        for(int i = 0; i<playerCollection.size(); i++)
        {
            playerRoster = playerRoster + playerArray[i].playerInfo() + "\n";
        }
        return playerRoster;
    }

}
