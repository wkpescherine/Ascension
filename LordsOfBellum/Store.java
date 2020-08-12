package com.example.lordsofbellum;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class Store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }

    public void backToHome(View v){
        Intent intent = new Intent(this, HomeArea.class);
        startActivity(intent);
    }
}
