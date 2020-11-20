package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.Layout;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class NFLSimGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nflsim_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void pickQB(View v){
        setContentView(R.layout.nfl_pick_player);
    }

    public void startGame(View v){
        Button homeBTN = findViewById(R.id.homeBTN);
        LinearLayout roster = findViewById(R.id.playerChoices);
        roster.setVisibility(View.INVISIBLE);
        homeBTN.setVisibility(View.INVISIBLE);
    }

    public void Home(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }
}//39