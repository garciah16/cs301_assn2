package com.example.administrator.assignment2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    protected Button managerBtn;
    protected TextView teamName;
    protected TextView teamStats;
    protected TextView teamMembers;
    protected TeamDataManager teamDM;
    protected int initTeam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managerBtn = (Button) findViewById(R.id.tomanager);

        //set up teams
        this.teamDM = new TeamDataManager();
        SoccerTeam rsl = teamDM.getSoccerTeam(initTeam);
        //display the first team on creation
        this.teamName = (TextView) findViewById(R.id.teamName);
        teamName.setText(rsl.teamName);
        //display the first team stats on creation
        this.teamStats = (TextView) findViewById(R.id.teamStats);
        teamStats.setText("Wins: "+ rsl.getWins()
                        + " Losses: " + rsl.getLosses()
                        + " Draws: " + rsl.getDraws());
        this.teamMembers = (TextView)findViewById(R.id.teamMembers);
        teamMembers.setText(rsl.printRoster());
    }//onCreate


    public void onClickListenerManager(View view) {
        Log.d("Main Activity", "managerBtn");
        Intent managerIntent = new Intent(this, ManagerActivity.class);
        startActivity(managerIntent);
    }//onClickListenerManager

    public void onClickListenerNext(View view) {
        Log.d("Main Activity", "nextTeamBtn");
        nextTeamDisplay();
    }//onClickListenerNext

    public void onClickListenerPrev(View view) {
        Log.d("Main Activity", "prevTeamBtn");
        prevTeamDisplay();
    }//onClickListenerPrev

    /**
     * get the next team and display it on the screen
     */
    private void nextTeamDisplay(){
        if(initTeam>=teamDM.soccerTeams.size()-1){ //if no more teams
                Log.d("Main Activity", "no more teams");
                return;
        }
        initTeam++;
        SoccerTeam nextTeam = teamDM.getSoccerTeam(initTeam);
        teamName.setText(nextTeam.teamName);
        teamStats.setText("Wins: "+ nextTeam.getWins()
                + " Losses: " + nextTeam.getLosses()
                + " Draws: " + nextTeam.getDraws());
        teamMembers.setText(nextTeam.printRoster());
        String teamPic;
        String teamLogo;
        switch (nextTeam.teamName) {
            case "Real Salt Lake":
                teamPic = "slc_team";
                teamLogo = "real_saltlake";
                break;
            case "Portland Timbers":
                teamPic = "timbers_team";
                teamLogo = "timbers";
                break;
            case "Seattle Sounders":
                teamPic = "sounders_team";
                teamLogo = "sounders";
                break;
            default:
                teamPic = "sounders_team";
                teamLogo = "sounders";
                break;
        }
        int res = getResources().getIdentifier(teamPic, "drawable", getPackageName());
        int logo = getResources().getIdentifier(teamLogo, "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.teamPicture);
        iv.setImageResource(res);
        iv = (ImageView) findViewById(R.id.teamLogo);
        iv.setImageResource(logo);
        return;
    }//nextTeamDisplay

    private void prevTeamDisplay() {
        if(initTeam<=0){
            Log.d("Main activity", "no more teams");
            return;
        }
        initTeam--;
        SoccerTeam prevTeam = teamDM.getSoccerTeam(initTeam);
        teamName.setText(prevTeam.teamName);
        teamStats.setText("Wins: "+ prevTeam.getWins()
                + " Losses: " + prevTeam.getLosses()
                + " Draws: " + prevTeam.getDraws());
        teamMembers.setText(prevTeam.printRoster());
        String teamPic;
        String teamLogo;
        switch (prevTeam.teamName) {
            case "Real Salt Lake":
                teamPic = "slc_team";
                teamLogo = "real_saltlake";
                break;
            case "Portland Timbers":
                teamPic = "timbers_team";
                teamLogo = "timbers";
                break;
            case "Seattle Sounders":
                teamPic = "sounders_team";
                teamLogo = "sounders";
                break;
            default:
                teamPic = "sounders_team";
                teamLogo = "sounders";
                break;
        }
        int res = getResources().getIdentifier(teamPic, "drawable", getPackageName());
        int logo = getResources().getIdentifier(teamLogo, "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.teamPicture);
        iv.setImageResource(res);
        iv = (ImageView) findViewById(R.id.teamLogo);
        iv.setImageResource(logo);
        return;
    }//prevTeamDisplay

}
