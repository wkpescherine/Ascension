package com.example.sportsmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    String center1 = "None";
    String position = "none";
    String possesion = "none";

    int [] playerPointsValue = { 0, 0, 0, 0, 0};
    int [] playerShotPerc = { 0, 0, 0, 0, 0};
    int [] playerRebounds = {0,0,0,0,0};
    int [] playerPoints = {0, 0, 0, 0, 0};

    String [] computerPlayerNames = {"none","none","none","none","none"};
    int [] computerPointsValue = { 0, 0, 0, 0, 0};
    int [] computerShotPerc = { 0, 0, 0, 0, 0};
    int [] computerRebounds = { 0, 0, 0, 0, 0};
    int [] computerPoints = { 0, 0, 0, 0, 0};

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
        PopulatePlayerList();
    }
    public void PickPos2(View v){
        setContentView(R.layout.nba_pick_player);
        position = "guard2";
        PopulatePlayerList();
    }
    public void PickPos3(View v){
        setContentView(R.layout.nba_pick_player);
        position = "forward1";
        PopulatePlayerList();
    }
    public void PickPos4(View v){
        setContentView(R.layout.nba_pick_player);
        position = "forward2";
        PopulatePlayerList();
    }
    public void PickPos5(View v){
        setContentView(R.layout.nba_pick_player);
        position = "center";
        PopulatePlayerList();
    }

    public void PopulatePlayerList(){
        for (int a =0; a<= 3; a++){
            int playerValue = a;

            switch(playerValue){
                case 0:
                    TextView p1 = findViewById(R.id.player1Name);
                    //if(guard1 == player.PlayerNameGuard[a] || guard2 == player.PlayerNameGuard[a]){
                    //    RelativeLayout playerSpot = findViewById(R.id.PlayerGuard1);
                    //    playerSpot.setVisibility(View.GONE);
                    //}else
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
            playerRebounds[0] = player.PlayerRebGuard[0];
            guard1 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[0];
            playerShotPerc[1] = player.PlayerShotPercGuard[0];
            playerRebounds[1] = player.PlayerRebGuard[0];
            guard2 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[0];
            playerShotPerc[2] = player.PlayerShotPercForward[0];
            playerRebounds[2] = player.PlayerRebForward[0];
            forward1 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[0];
            playerShotPerc[3] = player.PlayerShotPercForward[0];
            playerRebounds[3] = player.PlayerRebForward[0];
            forward2 = text1.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[0];
            playerShotPerc[4] = player.PlayerShotPercCenter[0];
            playerRebounds[4] = player.PlayerRebCenter[0];
            center1 = text1.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer2(View v){
        TextView text2 = findViewById(R.id.player2Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[1];
            playerShotPerc[0] = player.PlayerShotPercGuard[1];
            playerRebounds[0] = player.PlayerRebGuard[1];
            guard1 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[1];
            playerShotPerc[1] = player.PlayerShotPercGuard[1];
            playerRebounds[1] = player.PlayerRebGuard[1];
            guard2 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[1];
            playerShotPerc[2] = player.PlayerShotPercForward[1];
            playerRebounds[2] = player.PlayerRebForward[1];
            forward1 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[1];
            playerShotPerc[3] = player.PlayerShotPercForward[1];
            playerRebounds[3] = player.PlayerRebForward[1];
            forward2 = text2.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[1];
            playerShotPerc[4] = player.PlayerShotPercCenter[1];
            playerRebounds[4] = player.PlayerRebCenter[1];
            center1 = text2.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer3(View v){
        TextView text3 = findViewById(R.id.player3Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[2];
            playerShotPerc[0] = player.PlayerShotPercGuard[2];
            playerRebounds[0] = player.PlayerRebGuard[2];
            guard1 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[2];
            playerShotPerc[1] = player.PlayerShotPercGuard[2];
            playerRebounds[1] = player.PlayerRebGuard[2];
            guard2 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[2];
            playerShotPerc[2] = player.PlayerShotPercForward[2];
            playerRebounds[2] = player.PlayerRebForward[2];
            forward1 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[2];
            playerShotPerc[3] = player.PlayerShotPercForward[2];
            playerRebounds[3] = player.PlayerRebForward[2];
            forward2 = text3.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[2];
            playerShotPerc[4] = player.PlayerShotPercCenter[2];
            playerRebounds[4] = player.PlayerRebCenter[2];
            center1 = text3.getText().toString();
            PlayerPickedNameChange();
        }
    }
    public void PickPlayer4(View v){
        TextView text4 = findViewById(R.id.player4Name);
        if(position == "guard1"){
            playerPointsValue[0] = player.PlayerPointsGuard[3];
            playerShotPerc[0] = player.PlayerShotPercGuard[3];
            playerRebounds[0] = player.PlayerRebGuard[3];
            guard1 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "guard2"){
            playerPointsValue[1] = player.PlayerPointsGuard[3];
            playerShotPerc[1] = player.PlayerShotPercGuard[3];
            playerRebounds[1] = player.PlayerRebGuard[3];
            guard2 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward1"){
            playerPointsValue[2] = player.PlayerPointsForward[3];
            playerShotPerc[2] = player.PlayerShotPercForward[3];
            playerRebounds[2] = player.PlayerRebForward[3];
            forward1 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "forward2"){
            playerPointsValue[3] = player.PlayerPointsForward[3];
            playerShotPerc[3] = player.PlayerShotPercForward[3];
            playerRebounds[3] = player.PlayerRebForward[3];
            forward2 = text4.getText().toString();
            PlayerPickedNameChange();
        }
        if(position == "center"){
            playerPointsValue[4] = player.PlayerPointsCenter[3];
            playerShotPerc[4] = player.PlayerShotPercCenter[3];
            playerRebounds[4] = player.PlayerRebCenter[3];
            center1 = text4.getText().toString();
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
        if(center1 !="None"){
            pp5.setText(center1);
        }
        CheckGameReady();
    }

    public void Return(View v){
        setContentView(R.layout.activity_nbasim_game);
        PlayerPickedNameChange();
    }

    public void CheckGameReady(){
        if((guard1 != "None") && (guard2 != "None") && (forward1 != "None") && (forward2 != "None") && (center1 != "None")){
            Button startBtn = findViewById(R.id.StartGameBtn);
            Button rtnBtn = findViewById(R.id.returnChoice);
            startBtn.setVisibility(View.VISIBLE);
            rtnBtn.setVisibility(View.INVISIBLE);
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
        tipOff();
        pickCPUTeam();
        setScoreBoard();
        int time = 3000000;
        int interval = 1000;

        new CountDownTimer(time, interval) {
            TextView gameClock = findViewById(R.id.clock);
            TextView qtr = findViewById(R.id.quarter);
            Button homeBtn = findViewById(R.id.home);

            int quarter = 0;
            int gameTime = 30;
            int shotClock = 24;
            int [] ShotChance = { 0, 0, 0, 0, 0};
            String gameOver = "Over";

            public void onTick(long time) {
                int min = gameTime / 60;
                int sec = gameTime % 60;

                clockManager(min, sec);

                quarterManager();

                shotManager();

                if(quarter == 4 && gameTime == 0){
                    cancel();
                }

                shotClock -= 1;
                gameTime -= 1;
            }

            public void clockManager(int minGT, int secGT){
                if (secGT < 10) {
                    gameClock.setText(minGT + ":0" + secGT);
                }else {
                    gameClock.setText(minGT + ":" + secGT);
                }
            }

            public void quarterManager(){
                if (quarter == 0) {
                    quarter += 1;
                    qtr.setText(quarter + " qtr");
                } else if ((quarter > 0 && quarter < 4) && gameTime == 0) {
                    quarter += 1;
                    qtr.setText(quarter + " qtr");
                    gameTime = 31;
                    if(possesion == "Player"){
                        possesion = "Computer";
                        ShotChance[0] = 0;
                        shotClock = 24;
                        TextView pPoss = findViewById(R.id.playerPoss);
                        TextView cPoss = findViewById(R.id.cpuPoss);
                        cPoss.setText("Poss");
                        pPoss.setText("");
                    }else {
                        possesion = "Player";
                        ShotChance[0] = 0;
                        shotClock = 24;
                        TextView pPoss = findViewById(R.id.playerPoss);
                        TextView cPoss = findViewById(R.id.cpuPoss);
                        cPoss.setText("");
                        pPoss.setText("Poss");
                    }
                } else if (quarter == 4 && gameTime == 0) {
                    onFinish();
                }
            }

            public void shotManager(){
                if (possesion == "Player") {
                    if (ShotChance[0] == 0) {
                        for (int x = 0; x < 5; x++) {
                            ShotChance[x] = playerPointsValue[x];
                        }
                    } else {
                        Random chanceToShot = new Random();
                        int chanceNum = chanceToShot.nextInt(10000);
                        for (int a = 0; a < 5; a++) {
                            if(ShotChance[a] >= chanceNum ){
                                Random shotMade = new Random();
                                int madeShot = shotMade.nextInt(100);
                                if(playerShotPerc[a]> madeShot){
                                    playerPoints[a] += 2;
                                    setScoreBoard();
                                    possesion = "Computer";
                                    ShotChance[0] = 0;
                                    a = 6;
                                    TextView pPoss = findViewById(R.id.playerPoss);
                                    TextView cPoss = findViewById(R.id.cpuPoss);
                                    cPoss.setText("Poss");
                                    pPoss.setText("");
                                }
                            }else if(shotClock == 0){
                                possesion = "Computer";
                                ShotChance[0] = 0;
                                shotClock = 24;
                                TextView pPoss = findViewById(R.id.playerPoss);
                                TextView cPoss = findViewById(R.id.cpuPoss);
                                cPoss.setText("Poss");
                                pPoss.setText("");
                            } else{
                                ShotChance[a] += playerPointsValue[a];
                            }
                        }
                    }
                } else {
                    if (ShotChance[0] == 0) {
                        for (int x = 0; x < 5; x++) {
                            ShotChance[x] = computerPointsValue[x];
                        }
                    } else {
                        Random chanceToShot = new Random();
                        int chanceNum = chanceToShot.nextInt(10000);
                        for (int a = 0; a < 5; a++) {
                            if(ShotChance[a] >= chanceNum ){
                                Random shotMade = new Random();
                                int madeShot = shotMade.nextInt();
                                if(computerShotPerc[a]> madeShot){
                                    computerPoints[a] += 2;
                                    setScoreBoard();
                                    possesion = "Player";
                                    ShotChance[0] = 0;
                                    a = 6;
                                    TextView pPoss = findViewById(R.id.playerPoss);
                                    TextView cPoss = findViewById(R.id.cpuPoss);
                                    cPoss.setText("");
                                    pPoss.setText("Poss");
                                }
                                possesion = "Player";
                                ShotChance[0] = 0;
                            }else if(shotClock == 0){
                                possesion = "Player";
                                ShotChance[0] = 0;
                                shotClock = 24;
                                TextView pPoss = findViewById(R.id.playerPoss);
                                TextView cPoss = findViewById(R.id.cpuPoss);
                                cPoss.setText("");
                                pPoss.setText("Poss");
                            } else {
                                ShotChance[a] += playerPointsValue[a];
                            }
                        }
                    }
                }
            }

            public void onFinish() {
                 gameClock.setVisibility(View.INVISIBLE);
                 homeBtn.setVisibility(View.VISIBLE);
;                qtr.setText("Game Over");
            }
        }.start();

    }

    public void setScoreBoard(){
        TextView p1p1 = findViewById(R.id.player1pos1);
        TextView p1p1p = findViewById(R.id.player1pos1pts1);
        TextView c1p1 = findViewById(R.id.cpu1pos1);
        TextView c1p1p = findViewById(R.id.cpu1pos1pts1);
        TextView p1p2 = findViewById(R.id.player1pos2);
        TextView p1p2p = findViewById(R.id.player1pos2pts1);
        TextView c1p2 = findViewById(R.id.cpu1pos2);
        TextView c1p2p = findViewById(R.id.cpu1pos2pts1);
        TextView p1p3 = findViewById(R.id.player1pos3);
        TextView p1p3p = findViewById(R.id.player1pos3pts1);
        TextView c1p3 = findViewById(R.id.cpu1pos3);
        TextView c1p3p = findViewById(R.id.cpu1pos3pts1);
        TextView p1p4 = findViewById(R.id.player1pos4);
        TextView p1p4p = findViewById(R.id.player1pos4pts1);
        TextView c1p4 = findViewById(R.id.cpu1pos4);
        TextView c1p4p = findViewById(R.id.cpu1pos4pts1);
        TextView p1p5 = findViewById(R.id.player1pos5);
        TextView p1p5p = findViewById(R.id.player1pos5pts1);
        TextView c1p5 = findViewById(R.id.cpu1pos5);
        TextView c1p5p = findViewById(R.id.cpu1pos5pts1);
        TextView pScore = findViewById(R.id.playerScore);
        TextView cScore = findViewById(R.id.cpuScore);

        pScore.setText(playerPoints[0]+playerPoints[1]+playerPoints[2]+playerPoints[3]+playerPoints[4]+"");
        cScore.setText(computerPoints[0]+computerPoints[1]+computerPoints[2]+computerPoints[3]+computerPoints[4]+"");
        p1p1.setText(guard1);
        p1p1p.setText(playerPoints[0]+" ");
        c1p1.setText(computerPlayerNames[0]+" ");
        c1p1p.setText(computerPoints[0]+" ");
        p1p2.setText(guard2);
        p1p2p.setText(playerPoints[1]+" ");
        c1p2.setText(computerPlayerNames[1]+" ");
        c1p2p.setText(computerPoints[1]+" ");
        p1p3.setText(forward1);
        p1p3p.setText(playerPoints[2]+" ");
        c1p3.setText(computerPlayerNames[2]+" ");
        c1p3p.setText(computerPoints[2]+" ");
        p1p4.setText(forward2);
        p1p4p.setText(playerPoints[3]+" ");
        c1p4.setText(computerPlayerNames[3]+" ");
        c1p4p.setText(computerPoints[3]+" ");
        p1p5.setText(center1);
        p1p5p.setText(playerPoints[4]+" ");
        c1p5.setText(computerPlayerNames[4]+" ");
        c1p5p.setText(computerPoints[4]+" ");
    }

    public void pickCPUTeam(){
        Random num = new Random();
        int randNum1 = num.nextInt(4);
        int randNum2 = num.nextInt(4);
        int randNum3 = num.nextInt(4);
        int randNum4 = num.nextInt(4);
        int randNum5 = num.nextInt(4);

        computerPlayerNames[0]= player.PlayerNameGuard[randNum1];
        computerPointsValue[0]= player.PlayerPointsGuard[randNum1];
        computerPointsValue[0]= player.PlayerShotPercGuard[randNum1];
        computerPlayerNames[1]= player.PlayerNameGuard[randNum2];
        computerPointsValue[1]= player.PlayerPointsGuard[randNum1];
        computerPointsValue[1]= player.PlayerShotPercGuard[randNum1];
        computerPlayerNames[2]= player.PlayerNameForward[randNum3];
        computerPointsValue[2]= player.PlayerPointsForward[randNum3];
        computerPointsValue[2]= player.PlayerShotPercForward[randNum3];
        computerPlayerNames[3]= player.PlayerNameForward[randNum4];
        computerPointsValue[3]= player.PlayerPointsForward[randNum4];
        computerPointsValue[3]= player.PlayerShotPercForward[randNum4];
        computerPlayerNames[4]= player.PlayerNameCenter[randNum5];
        computerPointsValue[4]= player.PlayerPointsCenter[randNum5];
        computerPointsValue[4]= player.PlayerShotPercCenter[randNum5];
    }

    public void tipOff(){
        Random num = new Random();
        int randNum = num.nextInt(2) + 1;

        TextView pPoss = findViewById(R.id.playerPoss);
        TextView cPoss = findViewById(R.id.cpuPoss);

        if(possesion == "none" ){
            if(randNum == 1){
                possesion = "Player";
                cPoss.setText("");
                pPoss.setText("Poss");
            }else {
                possesion = "Computer";
                cPoss.setText("Poss");
                pPoss.setText("");
            }
        }
    }

    public void Home(View v){
        Intent intent = new Intent(this, SportChoice.class);
        startActivity(intent);
    }
}//593