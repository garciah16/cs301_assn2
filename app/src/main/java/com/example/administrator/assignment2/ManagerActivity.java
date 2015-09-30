package com.example.administrator.assignment2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * created by: Hunter Garcia
 * last edited: 9/29/15
 */

public class ManagerActivity extends ActionBarActivity {


    // set up all items on screen for use with the activity class
    Button addTeamBtn;
    Button addPlayerBtn;
    Button upTeamBtn;
    Button downTeamBtn;

    TextView teamName;

    EditText editTeam;
    EditText firstName;
    EditText lastName;
    EditText position;
    EditText playerNumber;

    int initTeam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        editTeam = (EditText) findViewById(R.id.editTeamName);
        editTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the text field when clicked
                editTeam.setText("", TextView.BufferType.EDITABLE);
            }
        });


        addTeamBtn = (Button) findViewById(R.id.addTeamButton);

        addTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add the new team to the TeamDataManager
                SoccerTeam newTeam = new SoccerTeam(editTeam.getText().toString());
                MainActivity.getTeamDM().addTeam(newTeam);
                editTeam.setText("Team added!", TextView.BufferType.EDITABLE);
            }
        });

        firstName = (EditText) findViewById(R.id.firstName);
        firstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear text field when clicked
                firstName.setText("", TextView.BufferType.EDITABLE);
            }
        });
        lastName = (EditText) findViewById(R.id.lastName);
        lastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear text field when clicked
                lastName.setText("", TextView.BufferType.EDITABLE);
            }
        });
        position = (EditText) findViewById(R.id.position);
        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear text field when clicked
                position.setText("", TextView.BufferType.EDITABLE);
            }
        });
        playerNumber = (EditText) findViewById(R.id.playerNumber);
        playerNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear text field when clicked
                playerNumber.setText("", TextView.BufferType.EDITABLE);
            }
        });

        teamName = (TextView) findViewById(R.id.teamNameDisplay);
        teamName.setText(MainActivity.getTeamDM().getSoccerTeam(initTeam).teamName);

        upTeamBtn = (Button) findViewById(R.id.upButton);
        upTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(initTeam<=0){return;} //no more teams to display
                initTeam--;
                SoccerTeam prevTeam = MainActivity.getTeamDM().getSoccerTeam(initTeam);
                teamName.setText(prevTeam.teamName);
            }
        });

        downTeamBtn = (Button) findViewById(R.id.downButton);
        downTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scroll down through the teams
                if(initTeam>=MainActivity.getTeamDM().soccerTeams.size()-1){return;}//no more teams
                initTeam++;
                SoccerTeam nextTeam = MainActivity.getTeamDM().getSoccerTeam(initTeam);
                teamName.setText(nextTeam.teamName);
            }
        });

        addPlayerBtn = (Button) findViewById(R.id.addPlayerButton);
        addPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new player to add to the current team chosen
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                String posit = position.getText().toString();
                int playerNum = Integer.parseInt(playerNumber.getText().toString());
                SoccerPlayer newPlayer = new SoccerPlayer(first, last, posit, playerNum);
                MainActivity.getTeamDM().getSoccerTeam(initTeam).addPlayer(newPlayer);
                //update the editable field
                firstName.setText("Player added!");
                lastName.setText("");
                position.setText("");
                playerNumber.setText("");
            }
        });
    }//onCreate

}
