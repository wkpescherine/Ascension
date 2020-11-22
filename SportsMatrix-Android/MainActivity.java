package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String username = "TestMode";
    String password = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void Enter(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }

    public void logIn(View v){
        setContentView(R.layout.main_log_in);
    }

    public void createAcct(View v){
        setContentView(R.layout.main_create_acct);
    }

    public void checkToLogIn(View v){
        EditText getUsername = findViewById(R.id.logUserName);
        String UserNameInput = getUsername.getText().toString();
        EditText getPassword = findViewById(R.id.logPasword);
        String PasswordInput = getPassword.getText().toString();
        if(username != UserNameInput || password!= PasswordInput){
            Toast.makeText(MainActivity.this, "Username or Passowrd incorrect.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, SportChoice.class);
            startActivity(intent);
        }
    }

    public void backToMain(View v){
        setContentView(R.layout.activity_main);
    }
}//55