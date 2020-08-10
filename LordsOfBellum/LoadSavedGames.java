package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class LoadSavedGames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_saved_games);
    }

    public void backToMain2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}