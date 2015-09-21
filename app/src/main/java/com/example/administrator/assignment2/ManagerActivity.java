package com.example.administrator.assignment2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class ManagerActivity extends ActionBarActivity {


    protected TeamDataManager teamDM;

    // spinner
    private ArrayList<String> teamVec;
    ArrayAdapter<String> adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        spinner = (Spinner) findViewById(R.id.teamSpinner);
        teamVec = new ArrayList<String>();
    //    adapter = new ArrayAdapter<String>(this, )
    }

}
