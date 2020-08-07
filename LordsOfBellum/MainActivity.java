package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View v){
        Intent intent = new Intent(this,SelectLord.class);
        startActivity(intent);
    }

    public void loadGame(View v){
        Intent intent = new Intent(this,LoadSavedGames.class);
        startActivity(intent);
    }
}