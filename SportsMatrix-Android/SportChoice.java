package com.example.sportsmatrix;

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
        Intent intent = new Intent(this, NBASimGame.class);
        startActivity(intent);
    }

    public void NBASimSeason(View v){
        //Intent intent = new Intent(this, NBASimGame.class);
        //startActivity(intent);
    }
    public void MLBSimGame(View v){
        Intent intent = new Intent(this,MLBSimGame.class);
        startActivity(intent);
    }
}//25