package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.WindowManager;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.Random;

public class NBASimGame extends AppCompatActivity {
    String guard1 = "None";
    String guard2 = "None";
    String forward1 = "None";
    String forward2 = "None";
    String center = "None";
    String position = "none";
    String possesion = "none";

    Double [] playerPointsValue = {0.0,0.0,0.0,0.0, 0.0};
    Double [] playerShotPerc = {0.0,0.0,0.0,0.0, 0.0};

    String [] computerPlayerNames = {"none","none","none","none","none"};
    Double [] computerPointsValue = {0.0,0.0,0.0,0.0, 0.0};
    Double [] computerShotPerc = {0.0,0.0,0.0,0.0, 0.0};

    NBAPlayerStats player = new NBAPlayerStats();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbasim_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void Back(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }

    public void PickPos1(View v){
        setContentView(R.layout.nba_pick_player);
        position = "guard1";
        PopulatePlayeerList();
    }
    public void PickPos2(View v){
        setContentView(R.layout.nba_pick_player);
        position = "guard2";
        PopulatePlayeerList();
    }
    public void PickPos3(View v){
        setContentView(R.layout.nba_pick_player);
        position = "forward1";
        PopulatePlayeerList();
    }
    public void PickPos4(View v){
        setContentView(R.layout.nba_pick_player);
        position = "forward2";
        PopulatePlayeerList();
    }
    public void PickPos5(View v){
        setContentView(R.layout.nba_pick_player);
        position = "center";
        PopulatePlayeerList();
    }

    public void PopulatePlayeerList(){
        for (int a =0; a<= 3; a++){
            int playerValue = a;

            switch(playerValue){
                case 0:
                    TextView p1 = findViewById(R.id.player1Name);
                    if(position.equals("guard1") || position.equals("guard2"))
                        p1.setText(player.PlayerNameGuard[a]);
                    if(position.equals("forward1") || position.equals("forward2"))
                        p1.setText(player.PlayerNameForward[a]);
                    if(position.equals("center"))
                        p1.setText(player.PlayerNameCenter[a]);
                    break;
                case 1:
                    TextView p2 = findViewById(R.id.player2Name);
                    if(position.equals("guard1") || position.equals("guard2"))
                        p2.setText(player.PlayerNameGuard[a]);
                    if(position.equals("forward1") || position.equals("forward2"))
                        p2.setText(player.PlayerNameForward[a]);
                    if(position.equals("center"))
                        p2.setText(player.PlayerNameCenter[a]);
                    break;
                case 2:
                    TextView p3 = findViewById(R.id.player3Name);
                    if(position.equals("guard1") || position.equals("guard2"))
                        p3.setText(player.PlayerNameGuard[a]);
                    if(position.equals("forward1") || position.equals("forward2"))
                        p3.setText(player.PlayerNameForward[a]);
                    if(position.equals("center"))
                        p3.setText(player.PlayerNameCenter[a]);
                    break;
                case 3:
                    TextView p4 = findViewById(R.id.player4Name);
                    if(position.equals("guard1") || position.equals("guard2"))
                        p4.setText(player.PlayerNameGuard[a]);
                    if(position.equals("forward1") || position.equals("forward2"))
                        p4.setText(player.PlayerNameForward[a]);
                    if(position.equals("center"))
                        p4.setText(player.PlayerNameCenter[a]);
                    break;
            }
        }
    }

    public void PickPlayer1(View v){
        TextView text1 = findViewById(R.id.player1Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[0];
            playerShotPerc[0] = player.PlayerShotPercGuard[0];
            guard1 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[0];
            playerShotPerc[1] = player.PlayerShotPercGuard[0];
            guard2 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[0];
            playerShotPerc[2] = player.PlayerShotPercForward[0];
            forward1 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[0];
            playerShotPerc[3] = player.PlayerShotPercForward[0];
            forward2 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[0];
            playerShotPerc[4] = player.PlayerShotPercCenter[0];
            center = text1.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer2(View v){
        TextView text2 = findViewById(R.id.player2Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[1];
            playerShotPerc[0] = player.PlayerShotPercGuard[1];
            guard1 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[1];
            playerShotPerc[1] = player.PlayerShotPercGuard[1];
            guard2 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[1];
            playerShotPerc[2] = player.PlayerShotPercForward[1];
            forward1 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[1];
            playerShotPerc[3] = player.PlayerShotPercForward[1];
            forward2 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[1];
            playerShotPerc[4] = player.PlayerShotPercCenter[1];
            center = text2.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer3(View v){
        TextView text3 = findViewById(R.id.player3Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[2];
            playerShotPerc[0] = player.PlayerShotPercGuard[2];
            guard1 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[2];
            playerShotPerc[1] = player.PlayerShotPercGuard[2];
            guard2 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[2];
            playerShotPerc[2] = player.PlayerShotPercForward[2];
            forward1 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[2];
            playerShotPerc[3] = player.PlayerShotPercForward[2];
            forward2 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[2];
            playerShotPerc[4] = player.PlayerShotPercCenter[2];
            center = text3.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer4(View v){
        TextView text4 = findViewById(R.id.player4Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[3];
            playerShotPerc[0] = player.PlayerShotPercGuard[3];
            guard1 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[3];
            playerShotPerc[1] = player.PlayerShotPercGuard[3];
            guard2 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[3];
            playerShotPerc[2] = player.PlayerShotPercForward[3];
            forward1 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[3];
            playerShotPerc[3] = player.PlayerShotPercForward[3];
            forward2 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[3];
            playerShotPerc[4] = player.PlayerShotPercCenter[3];
            center = text4.getText().toString();
            PlayerPickedNameChange();
        }
    }

    public void PlayerPickedNameChange(){
        setContentView(R.layout.activity_nbasim_game);

        TextView pp1 = findViewById(R.id.guard1);
        TextView pp2 = findViewById(R.id.guard2);
        TextView pp3 = findViewById(R.id.forward1);
        TextView pp4 = findViewById(R.id.forward2);
        TextView pp5 = findViewById(R.id.center);

        if(guard1 !="None"){
            pp1.setText(guard1);
        }
        if(guard2 !="None"){
            pp2.setText(guard2);
        }
        if(forward1 !="None"){
            pp3.setText(forward1);
        }
        if(forward2 !="None"){
            pp4.setText(forward2);
        }
        if(center !="None"){
            pp5.setText(center);
        }
        CheckGameReady();
    }

    public void Return(View v){
        setContentView(R.layout.activity_nbasim_game);
        PlayerPickedNameChange();
    }

    public void CheckGameReady(){
        if(guard1 != "None" && guard2 != "None" && forward1 != "None" && forward2 != "None" && center != "None"){
            Button startBtn = findViewById(R.id.StartGameBtn);
            startBtn.setVisibility(View.VISIBLE);
        }
    }

    public void StartGame(View v){
        Button returnBtn = findViewById(R.id.returnChoice);
        Button startBtn = findViewById(R.id.StartGameBtn);
        LinearLayout layout1 = findViewById(R.id.playerSelection);
        LinearLayout layout2 = findViewById(R.id.scoreboard);
        layout1.setVisibility(View.GONE);
        returnBtn.setVisibility(View.GONE);
        startBtn.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
        RunGame();
    }

    public void RunGame(){
        pickCPUTeam();
        setScoreBoard();
        int time = 120000;
        int interval = 1000;
        String overtime = "overtime";
        Random num = new Random();
        int randNum = num.nextInt(2);
        if(possesion == "none"){
            if(randNum == 0)
                possesion = "Player";
            else
                possesion = "computer";
        }
        new CountDownTimer(time, interval) {
            TextView gameClock = findViewById(R.id.clock);
            TextView qtr = findViewById(R.id.quarter);
            int quarter = 0;

            public void onTick(long time) {
                int min = (Long.valueOf(time).intValue())/60000;
                int sec = ((Long.valueOf(time).intValue())%60000)/1000;

                if(sec <10)
                    gameClock.setText(min+":0"+ sec);
                else
                    gameClock.setText(min+":"+ sec);

                if(quarter == 0 || time == 0) {
                    quarter += 1;
                    qtr.setText(quarter + " qtr");
                }
            }
            public void onFinish() {
                TextView gameClock = findViewById(R.id.clock);
                gameClock.setText("0:00");
            }
        }.start();
    }

    public void setScoreBoard(){
        TextView p1p1 = findViewById(R.id.player1pos1);
        TextView c1p1 = findViewById(R.id.cpu1pos1);
        TextView p1p2 = findViewById(R.id.player1pos2);
        TextView c1p2 = findViewById(R.id.cpu1pos2);
        TextView p1p3 = findViewById(R.id.player1pos3);
        TextView c1p3 = findViewById(R.id.cpu1pos3);
        TextView p1p4 = findViewById(R.id.player1pos4);
        TextView c1p4 = findViewById(R.id.cpu1pos4);
        TextView p1p5 = findViewById(R.id.player1pos5);
        TextView c1p5 = findViewById(R.id.cpu1pos5);

        p1p1.setText(guard1);
        c1p1.setText(computerPlayerNames[0]);
        p1p2.setText(guard2);
        c1p2.setText(computerPlayerNames[1]);
        p1p3.setText(forward1);
        c1p3.setText(computerPlayerNames[2]);
        p1p4.setText(forward2);
        c1p4.setText(computerPlayerNames[3]);
        p1p5.setText(center);
        c1p5.setText(computerPlayerNames[4]);
    }

    public void pickCPUTeam(){
        Random num = new Random();
        int randNum1 = num.nextInt(5);
        int randNum2 = num.nextInt(5);
        int randNum3 = num.nextInt(5);
        int randNum4 = num.nextInt(5);
        int randNum5 = num.nextInt(5);

        computerPlayerNames[0]= player.PlayerNameGuard[randNum1];
        computerPlayerNames[1]= player.PlayerNameGuard[randNum2];
        computerPlayerNames[2]= player.PlayerNameForward[randNum3];
        computerPlayerNames[3]= player.PlayerNameForward[randNum4];
        computerPlayerNames[4]= player.PlayerNameCenter[randNum5];
    }
}//334