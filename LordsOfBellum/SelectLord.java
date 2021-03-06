package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class SelectLord extends AppCompatActivity {

    String lordClass = "None";
    ConfigData configdata = new ConfigData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lord);
    }

    public void backToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void selectNecro(View v){
        configdata.lordClass = "Necro";
        configdata.manaType = "Death";
        configdata.manaValue = 1;
        configdata.attack = 5;
        configdata.defense = 3;
        configdata.quickness = 3;
        configdata.intelligence = 7;
        configdata.health = 10;
        Intent intent1 = new Intent(this, HomeArea.class);
        startActivity(intent1);
    }

    public void selectDragoon(View v){
        configdata.lordClass = "Dragoon";
        configdata.manaType = "Fire";
        configdata.manaValue = 1;
        configdata.attack = 9;
        configdata.defense = 6;
        configdata.quickness = 1;
        configdata.intelligence = 2;
        configdata.health = 15;

        Intent intent2 = new Intent(this, HomeArea.class);
        startActivity(intent2);
    }

    public void selectVeilus(View v){
        configdata.lordClass = "Veilus";
        configdata.manaType = "Nature";
        configdata.manaValue = 1;
        configdata.attack = 3;
        configdata.defense = 5;
        configdata.quickness = 6;
        configdata.intelligence = 2;
        configdata.health = 8;

        Intent intent3 = new Intent(this, HomeArea.class);
        startActivity(intent3);
    }
}