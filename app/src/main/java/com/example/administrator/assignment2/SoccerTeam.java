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
    }//SoccerTeam

    public int getWins(){
        return this.wins;
    }//getWins
    public void bumpWins(){
        this.wins++;
    }//bumpWins

    public int getLosses(){
        return this.losses;
    }//getLosses
    public void bumpLosses(){
        this.losses++;
    }//bumpLosses

    public int getDraws(){
        return this.draws;
    }//getDraws
    public void bumpDraws(){
        this.draws++;
    }//bumpDraws

    /**
     * put a new player into the team roster
     * @param player is a new player
     */
    public void addPlayer(SoccerPlayer player){
        playersTable.put(player.toString(), player);
    }//addPlayer

    public String printRoster(){
        //turn the hashtable into a collection in order to convert to an array
        Collection<SoccerPlayer> playerCollection = playersTable.values();
        SoccerPlayer[] playerArray = playerCollection.toArray(new SoccerPlayer[playersTable.size()]);

        //turn the array of players into a printable string for viewing on screen
        String playerRoster = "";
        for(int i = 0; i<playerArray.length; i++)
        {
            playerRoster = playerRoster + playerArray[i].playerInfo() + "\n";
        }
        return playerRoster;
    }//printRoster

}
