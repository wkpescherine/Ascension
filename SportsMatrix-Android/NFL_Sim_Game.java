package com.example.sportsmatrix_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.Layout;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NFL_Sim_Game extends AppCompatActivity {

    NFLPlayerStats nflPlayer = new NFLPlayerStats();

    String [] playerTeam = {"None"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfl__sim__game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void pickQB(View v){
        setContentView(R.layout.nfl_pick_player);
        PopulatePlayers("QB");
    }

    public void pickRB(View v){
        setContentView(R.layout.nfl_pick_player);
        PopulatePlayers("RB");
    }

    public void startGame(View v){
        Button homeBTN = findViewById(R.id.homeBTN);
        LinearLayout roster = findViewById(R.id.playerChoices);
        roster.setVisibility(View.INVISIBLE);
        homeBTN.setVisibility(View.INVISIBLE);
    }

    public void PopulatePlayers(String position){
        for (int a =0; a<= 1; a++){
            int playerToPopulate = a;

            switch(position){
                case "QB":
                    if(playerToPopulate == 0){
                        TextView p1 = findViewById(R.id.player1);
                        p1.setText(nflPlayer.Quarterback[a]);
                    };
                    break;
                case "RB":
                    if(playerToPopulate == 0){
                        TextView p1 = findViewById(R.id.player1);
                        p1.setText(nflPlayer.RunningBack[a]);
                    };
                    break;
                case "WR":
                    if(playerToPopulate == 0){
                        TextView p1 = findViewById(R.id.player1);
                        p1.setText(nflPlayer.WideReceiver[a]);
                    };
            }
        }
    }

    public void Return(View v){
        setContentView(R.layout.activity_nfl__sim__game);
    }

    public void Home(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }
}//80