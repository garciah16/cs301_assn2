package com.example.administrator.assignment2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    protected Button managerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managerBtn = (Button) findViewById(R.id.tomanager);

        //set up teams
        TeamDataManager teamDM = new TeamDataManager();
        SoccerTeam rsl = teamDM.getSoccerTeam(0);
        //display the first team on creation
        TextView teamName = (TextView) findViewById(R.id.teamName);
        teamName.setText(rsl.teamName);
        //display the first team stats on creation
        TextView teamStats = (TextView) findViewById(R.id.teamStats);
        teamStats.setText("Wins: "+ rsl.getWins()
                        + " Losses: " + rsl.getLosses()
                        + " Draws: " + rsl.getDraws());
        TextView teamMembers = (TextView)findViewById(R.id.teamMembers);
        teamMembers.setText(rsl.printRoster());
    }


    public void onClickListenerManager(View view) {
        Log.d("Main Activity", "managerBtn");
        Intent managerIntent = new Intent(this, ManagerActivity.class);
        startActivity(managerIntent);
    }
}
