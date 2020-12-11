package com.example.sportsmatrix_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.os.Bundle;

public class SportChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_choice);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void NBASimGame(View v){
        Intent intent = new Intent(this, NBA_Sim_Game.class);
        startActivity(intent);
    }

    public void NBASimSeason(View v){
        Intent intent = new Intent(this, NBA_Sim_Season.class);
        startActivity(intent);
    }

    public void NBALiveTourn(View v){
        Intent intent = new Intent(this, NBA_Live_Tourn.class);
        startActivity(intent);
    }

    public void MLBSimGame(View v){
        Intent intent = new Intent(this,MLB_Sim_Game.class);
        startActivity(intent);
    }

    public void NFLSimGame(View v){
        Intent intent = new Intent(this, NFL_Sim_Game.class);
        startActivity(intent);
    }
}//45