package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class HomeArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_area);
    }

    public void enterDungeon(View v){
        Intent intent = new Intent(this,Dungeon.class);
        startActivity(intent);
    }

    public void openStore(View v){
        Intent intent1 = new Intent( this, Store.class);
        startActivity(intent1);
    }
}