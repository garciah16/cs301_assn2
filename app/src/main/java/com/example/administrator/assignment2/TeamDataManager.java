package com.example.administrator.assignment2;

import java.util.ArrayList;

/**
 * this class creates a few teams automatically to test the app functionality
 * Created by garciah16 on 9/20/2015.
 */
public class TeamDataManager {

    protected ArrayList<SoccerTeam> soccerTeams = new ArrayList<SoccerTeam>();

    //create all teams automatically
    public TeamDataManager(){
        //create all the teams at once and add them to the array list
        soccerTeams.add(buildRSL());
        soccerTeams.add(buildPT());
    }

    public SoccerTeam getSoccerTeam(int element){
        return soccerTeams.get(element);
    }//getSoccerTeams

    //build an automatic team
    private SoccerTeam buildRSL(){
        SoccerPlayer lalo = new SoccerPlayer("Lalo", "Fernandez", "Goalkeep", 1);
        SoccerPlayer tony = new SoccerPlayer("Tony", "Beltran", "Defender", 2);
        SoccerPlayer aaron = new SoccerPlayer("Aaron", "Maund", "Defender", 21);
        SoccerPlayer devon = new SoccerPlayer("Devon", "Sandoval", "Forward", 49);
        SoccerPlayer olmes = new SoccerPlayer("Olmes", "Garcia", "Forward", 13);
        SoccerPlayer nick = new SoccerPlayer("Nick", "Rimando", "Goalkeep", 18);
        SoccerPlayer javier = new SoccerPlayer("Javier", "Morales", "Midfield", 11);
        SoccerPlayer luke = new SoccerPlayer("Luke", "Mulholland", "Midfield", 19);
        SoccerPlayer adolfo = new SoccerPlayer("Adolfo", "Ovalle", "Midfield", 26);

        SoccerTeam rsl = new SoccerTeam("Real Salt Lake");
        rsl.addPlayer(lalo);
        rsl.addPlayer(tony);
        rsl.addPlayer(aaron);
        rsl.addPlayer(devon);
        rsl.addPlayer(olmes);
        rsl.addPlayer(nick);
        rsl.addPlayer(javier);
        rsl.addPlayer(luke);
        rsl.addPlayer(adolfo);
        return rsl;
    }//buildRSL

    //build an automatic team
    private SoccerTeam buildPT(){
        SoccerPlayer fandendo = new SoccerPlayer("Fanendo", "Adi", "Forward", 9);
        SoccerPlayer nat = new SoccerPlayer("Nat", "Borchers", "Defender", 7);
        SoccerPlayer jack = new SoccerPlayer("Jack", "Jewsbury", "Defender", 13);
        SoccerPlayer dairon = new SoccerPlayer("Dairon", "Asprilla", "Forward", 11);
        SoccerPlayer lucas = new SoccerPlayer("Lucas", "Melano", "Forward", 26);
        SoccerPlayer adam = new SoccerPlayer("Adam", "Kwarasey", "Goalkeep", 12);
        SoccerPlayer will = new SoccerPlayer("Will", "Johnson", "Midfield", 4);
        SoccerPlayer michael = new SoccerPlayer("Michael", "Nanchoff", "Midfield", 17);
        SoccerPlayer darlington = new SoccerPlayer("Darlington", "Nagbe", "Midfield", 6);

        SoccerTeam timbers = new SoccerTeam("Portland Timbers");
        timbers.addPlayer(fandendo);
        timbers.addPlayer(nat);
        timbers.addPlayer(jack);
        timbers.addPlayer(dairon);
        timbers.addPlayer(lucas);
        timbers.addPlayer(adam);
        timbers.addPlayer(will);
        timbers.addPlayer(michael);
        timbers.addPlayer(darlington);
        return timbers;
    }//buildPT

}//TeamDataManager
