package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class NBA_Sim_Season extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba__sim__season);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void Back(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }

    public void toRoster(View v){
        setContentView(R.layout.nba_sim_season_roster);
    }

    public void toStandings(View v){
        setContentView(R.layout.nba_sim_season_standing);
    }

    public void toSchedule(View v){
        setContentView(R.layout.nba_sim_season_schedule);
    }

    public void pick_Knicks(View v){
        setContentView(R.layout.nba_sim_season_roster);
    }
}//41