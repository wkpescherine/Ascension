package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class SportChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_choice);
    }

    public void StartNBAGame(View v){
        Intent intent3 = new Intent(this, NBASimGame.class);
        startActivity(intent3);
    }
}
