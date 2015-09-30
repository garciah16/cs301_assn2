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
/*
picture references used:
http://sheaf1.wpengine.netdna-cdn.com/wp-content/uploads/2012/09/soccer-preview_RPEZ-stock.jpg
http://img4.wikia.nocookie.net/__cb20131231013931/object-overload/images/c/cc/Soccerball_Body_Updated.png
http://eskipaper.com/images/soccer-field-1.jpg
http://www.tornbysports.com/wp-content/uploads/2014/03/team-2014.jpg
http://img1.wikia.nocookie.net/__cb20140624154635/logopedia/images/d/d0/Real_Salt_Lake_logo_(RSL_crest).png
https://alaskaairblog.files.wordpress.com/2015/03/timbers.jpg?w=960&h=651&crop=1
http://gametimewatchshop.com/c/179-category_default/portland-timbers.jpg
http://cdn.fansided.com/wp-content/blogs.dir/166/files/2014/12/mls-western-conference-championship
        -los-angeles-galaxy-seattle-sounders-850x560.jpg
http://img3.wikia.nocookie.net/__cb20100925055853/logopedia/images/7/7c/Seattle_Sounders_FC.png

created by: Hunter Garcia
last edited: 9/29/15
 */

public class MainActivity extends ActionBarActivity {

    protected Button managerBtn;
    protected TextView teamName;
    protected TextView teamStats;
    protected TextView teamMembers;
    public static TeamDataManager teamDM = new TeamDataManager();
    protected int initTeam = 0; //variable to keep track of what team is on screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managerBtn = (Button) findViewById(R.id.tomanager);

        //set up teams
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

    //get the TeamDataManager
    public static TeamDataManager getTeamDM(){
        return teamDM;
    }
    //set the TeamDataManager
    public static void setTeamDM(TeamDataManager teamDataManager){
        teamDM = teamDataManager;
    }

    public void onClickListenerManager(View view) {
        Log.d("Main Activity", "managerBtn");
        //load the new activity
        Intent managerIntent = new Intent(this, ManagerActivity.class);
        startActivity(managerIntent);
    }//onClickListenerManager

    public void onClickPlayListener(View view) {
        //go to the game activty;
        Intent game = new Intent(this, GameActivity.class);
        startActivity(game);
    }//onClickPlayListener

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
        //increment current team index
        initTeam++;
        SoccerTeam nextTeam = teamDM.getSoccerTeam(initTeam);
        //update values to current team
        teamName.setText(nextTeam.teamName);
        teamStats.setText("Wins: "+ nextTeam.getWins()
                + " Losses: " + nextTeam.getLosses()
                + " Draws: " + nextTeam.getDraws());
        teamMembers.setText(nextTeam.printRoster());

        String teamPic;
        String teamLogo;

        //switch statement to display a soccer team "drawable" depending on the team name
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
                teamPic = "soccer_stock";
                teamLogo = "soccer_ball";
                break;
        }
        //set the resource to the correct picture
        int res = getResources().getIdentifier(teamPic, "drawable", getPackageName());
        int logo = getResources().getIdentifier(teamLogo, "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.teamPicture);
        iv.setImageResource(res);
        //set the logo image
        iv = (ImageView) findViewById(R.id.teamLogo);
        iv.setImageResource(logo);
    }//nextTeamDisplay

    private void prevTeamDisplay() {
        if(initTeam<=0){
            Log.d("Main activity", "no more teams");
            return;
        }
        //decrement the current team ID
        initTeam--;
        SoccerTeam prevTeam = teamDM.getSoccerTeam(initTeam);
        //set values in window to the new team
        teamName.setText(prevTeam.teamName);
        teamStats.setText("Wins: "+ prevTeam.getWins()
                + " Losses: " + prevTeam.getLosses()
                + " Draws: " + prevTeam.getDraws());
        teamMembers.setText(prevTeam.printRoster());
        //update the team picture and logo
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
                teamPic = "soccer_stock";
                teamLogo = "soccer_ball";
                break;
        }
        //set resource values to find resource id of the images
        int res = getResources().getIdentifier(teamPic, "drawable", getPackageName());
        int logo = getResources().getIdentifier(teamLogo, "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.teamPicture);
        iv.setImageResource(res);
        iv = (ImageView) findViewById(R.id.teamLogo);
        iv.setImageResource(logo);
    }//prevTeamDisplay

    @Override
    protected void onResume() {
        super.onResume();
        //refresh the stats and roster whenever the activity resumes, because it got updated
        SoccerTeam current = teamDM.getSoccerTeam(initTeam);
        teamStats.setText("Wins: "+ current.getWins()
                + " Losses: " + current.getLosses()
                + " Draws: " + current.getDraws());
        teamMembers.setText(teamDM.getSoccerTeam(initTeam).printRoster());
    }//onResume
}
