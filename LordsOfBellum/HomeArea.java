package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeArea extends AppCompatActivity {

    ConfigData configdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_area);
    }

    public void moveUp(View v){
        TextView getView = findViewById(R.id.moveThis);
        getView.android:layout_marginTop= 100;
    }

    public void moveDown(View v){

    }
}
