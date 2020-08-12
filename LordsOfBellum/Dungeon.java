package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Dungeon extends AppCompatActivity {

    int xCoord = 125;
    int yCoord = 225;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon);
        setSquare();
    }

    public void moveDown(View v){
        xCoord -= 50;
        setSquare();
    }

    public void moveUp(View v){
        xCoord += 50;
        setSquare();
    }

    public void moveLeft(View v){
        yCoord -= 50;
        setSquare();
    }

    public void moveRight(View v){
        yCoord += 50;
        setSquare();
    }

    public void setSquare(){
        LinearLayout ll = findViewById(R.id.moveThis);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams)
                ll.getLayoutParams();
        params.setMargins(yCoord,xCoord,0,0);
        ll.setLayoutParams(params);
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, HomeArea.class);
        startActivity(intent);
    }
}