package com.example.administrator.assignment2;

/**
 * Created by garciah16 on 9/20/2015.
 */
public class SoccerPlayer {

    private String firstName;
    private String lastName;
    private String position;
    private int number;

    public SoccerPlayer(String first, String last, String position, int num){
        this.firstName = first;
        this.lastName = last;
        this.position = position;
        this.number = num;
    }

    @Override
    public String toString() {
        return firstName+"_"+lastName;
    }

    public String playerInfo(){
        return number + " - " + firstName + " " + lastName + " - " + position;
    }
}
