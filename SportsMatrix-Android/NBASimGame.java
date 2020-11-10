package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class NBASimGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbasim_game);
    }

    public void Back(View v){
        Intent intent3 = new Intent(this, SportChoice.class);
        startActivity(intent3);
    }
}