package com.example.administrator.assignment2;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * created by: Hunter Garcia
 * last edited: 9/29/15
 */

public class GameActivity extends ActionBarActivity {

    Button prevTeamHomeBtn;
    Button prevTeamAwayBtn;
    Button nextTeamHomeBtn;
    Button nextTeamAwayBtn;
    Button goBackBtn;
    Button playBtn;

    TextView homeTeamName;
    TextView awayTeamName;
    TextView winnerName;
    TextView winnerName2;

    ImageView awayTeamImg;
    ImageView homeTeamImg;
    ImageView fieldImage;

    SoccerTeam awayTeam;
    SoccerTeam homeTeam;
    int homeTeamNum = 0;
    int awayTeamNum = homeTeamNum + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        prevTeamHomeBtn = (Button) findViewById(R.id.prevTeamHome);
        prevTeamAwayBtn = (Button) findViewById(R.id.prevTeamAway);
        nextTeamAwayBtn = (Button) findViewById(R.id.nextTeamAway);
        nextTeamHomeBtn = (Button) findViewById(R.id.nextTeamHome);
        goBackBtn = (Button) findViewById(R.id.back);
        playBtn = (Button) findViewById(R.id.playBtn);
        homeTeamName = (TextView) findViewById(R.id.homeTeamName);
        awayTeamName = (TextView) findViewById(R.id.awayTeamName);
        winnerName = (TextView) findViewById(R.id.winnerName);
        winnerName2 = (TextView) findViewById(R.id.winnername2);
        awayTeamImg = (ImageView) findViewById(R.id.awayTeamImage);
        homeTeamImg = (ImageView) findViewById(R.id.homeTeamImage);
        fieldImage = (ImageView) findViewById(R.id.fieldView);

        //initialize the home team and image
        homeTeam = MainActivity.getTeamDM().getSoccerTeam(homeTeamNum);
        homeTeamName.setText(homeTeam.teamName);
        int res = getResources().getIdentifier("real_saltlake", "drawable", getPackageName());
        homeTeamImg.setImageResource(res);

        //initialize the away team and image
        awayTeam = MainActivity.getTeamDM().getSoccerTeam(awayTeamNum);
        awayTeamName.setText(awayTeam.teamName);
        res = getResources().getIdentifier("timbers", "drawable", getPackageName());
        awayTeamImg.setImageResource(res);


        //go back to old activity
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jump back to main activity
                finish();
            }
        });
    }//onCreate

    /**
     * play button will choose a team randomly
     * and display it onscreen as the winning team,
     * and update team stats.
     */
    public void onClickPlayHandler(View view){
        SoccerTeam winner;
        //determine a winner from the two teams
        double rand = Math.random();
        if(rand>.6){
            winner = homeTeam;
            //update stats
            homeTeam.bumpWins();
            awayTeam.bumpLosses();
        }
        else if(rand<.3) {
            winner = awayTeam;
            //update stats
            homeTeam.bumpLosses();
            awayTeam.bumpWins();
        }
        else{
            winnerName.setTextColor(Color.RED);
            winnerName.setText("It's a draw!");
            winnerName2.setText("");
            //update stats and return
            homeTeam.bumpDraws();
            awayTeam.bumpDraws();
            return;
        }
        //now display the winner on screen
        winnerName.setTextColor(Color.RED);
        winnerName.setText("The winner is");
        winnerName2.setText(winner.teamName);
    }//onClickPlayHandler

    /**
     * this method will get the previous team to display on screen for either
     * home or away teams. it will recursively go through the team list
     * to find a team that is not already on screen.
     */
    public void prevTeamDisplay(View view){
        if(view == prevTeamAwayBtn) {
            //check if there are any more teams
            if (awayTeamNum<=0) { //if no more teams
                Log.d("Game Activity", "no more teams");
                return;
            }
            //if more teams, get the next team
            awayTeamNum--;
            SoccerTeam prevTeam = MainActivity.getTeamDM().getSoccerTeam(awayTeamNum);
            //if the previous team is already on screen, try again.
            if (prevTeam == homeTeam || prevTeam == awayTeam) {
                prevTeamDisplay(view);
                return;
            }
            awayTeam = prevTeam;
            //get resource for drawable image
            int res = getImgResource(awayTeam);
            awayTeamImg.setImageResource(res);
            awayTeamName.setText(prevTeam.teamName);
        }
        else {
            //check if there are any more teams
            if (homeTeamNum<=0) { //if no more teams
                Log.d("Game Activity", "no more teams");
                return;
            }
            //if more teams, get the next team
            homeTeamNum--;
            SoccerTeam prevTeam = MainActivity.getTeamDM().getSoccerTeam(homeTeamNum);
            //if the next team is already on screen, try again.
            if (prevTeam == homeTeam || prevTeam == awayTeam) {
                prevTeamDisplay(view);
                //done updating
                return;
            }
            homeTeam = prevTeam;
            //get resource for drawable image
            int res = getImgResource(homeTeam);
            homeTeamImg.setImageResource(res);
            homeTeamName.setText(prevTeam.teamName);
        }
    }//prevTeamDisplay

    /**
     * this method will get the next team to display on screen for either
     * home or away teams. it will recursively go through the team list
     * to find a team that is not already on screen.
     */
    public void nextTeamDisplay(View view) {
        if (view == nextTeamAwayBtn) {
            //check if there are any more teams
            if (awayTeamNum >= MainActivity.getTeamDM().soccerTeams.size() - 1) { //if no more teams
                Log.d("Game Activity", "no more teams");
                return;
            }
            //if more teams, get the next team
            awayTeamNum++;
            SoccerTeam nextTeam = MainActivity.getTeamDM().getSoccerTeam(awayTeamNum);
            //if the next team is already on screen, try again.
            if (nextTeam == homeTeam || nextTeam == awayTeam) {
                nextTeamDisplay(view);
                return;
            }
            awayTeam = nextTeam;
            //get the picture resource ID so we can update the screen
             int res = getImgResource(awayTeam);
            awayTeamImg.setImageResource(res);
            awayTeamName.setText(nextTeam.teamName);
        } else {
            //check if there are any more teams
            if (homeTeamNum >= MainActivity.getTeamDM().soccerTeams.size() - 1) { //if no more teams
                Log.d("Game Activity", "no more teams");
                return;
            }
            //if more teams, get the next team
            homeTeamNum++;
            SoccerTeam nextTeam = MainActivity.getTeamDM().getSoccerTeam(homeTeamNum);
            //if the next team is already on screen, try again.
            if (nextTeam == homeTeam || nextTeam == awayTeam) {
                nextTeamDisplay(view);
                //done updating
                return;
            }
            homeTeam = nextTeam;
            //get the picture resource ID so we can update the screen
            int res = getImgResource(homeTeam);
            homeTeamImg.setImageResource(res);
            homeTeamName.setText(nextTeam.teamName);
        }

    }//nextTeamDisplay

    /*
     * helper method to determine an image to display when given a team
     */
    private int getImgResource(SoccerTeam team){
        String teamLogo;
        switch (team.teamName) {
            case "Real Salt Lake":
                teamLogo = "real_saltlake";
                break;
            case "Portland Timbers":
                teamLogo = "timbers";
                break;
            case "Seattle Sounders":
                teamLogo = "sounders";
                break;
            default:
                teamLogo = "soccer_ball";
                break;
        }
        return getResources().getIdentifier(teamLogo, "drawable", getPackageName());
    }//getImgResource


}
