import java.lang.String;
import java.util.Arrays;

public class StatBuilder{
    int [][] statsTemp = new int[3][6];
    int [] stats = {0,0,0,0,0,0};
    int [] statsBonus = {0,0,0,0,0,0};
    String style = "none";
    String race = "none";
    String profession = "none";
    String charName = "none";
    int hp = 0;
    int power = 0;
    int lvl = 1;
    int currentXP = 0;
    int nextXP = 1000;
    int xpWorth = 0;
   
    //String [] holder = new String[7];

    //String being passed in looks like this "Rogue,p,2,1,4,5,0,0"
    //The following is a reference to how the information is being passed and what each index maps to
    public void setStats(String choice, int SRP, int STR, int CON, int DEX, int QUI, int INT , int SPR){
        if(SRP == 0){style = choice;}
        if(SRP == 1){race = choice;}
        if(SRP == 2){profession = choice;}

        statsTemp [SRP][0] = STR;
        statsTemp [SRP][1] = CON;
        statsTemp [SRP][2] = DEX;
        statsTemp [SRP][3] = QUI;
        statsTemp [SRP][4] = INT;
        statsTemp [SRP][5] = SPR;

        for(int a = 0; a<6; a++){
            stats[a] = statsTemp[0][a]+statsTemp[1][a]+statsTemp[2][a];
        }
        
        for(int i = 0; i<6; i++){
            int bonusTemp = 0;
            int modBonus = 0;
            for(int x = 0; x<stats[i]; x++){
                bonusTemp += x;
                if(bonusTemp+x < stats[i]){
                    modBonus += 1;
                }
            }
            statsBonus[i] = modBonus;
        }

        if(profession == "Warrior"){
            hp = 12+statsBonus[2];
        }
        if(profession == "Rogue"){
            hp = 8+statsBonus[2];
        }
        if(profession == "Mage"){
            hp = 4+statsBonus[2];
            power = 12+statsBonus[4]; 
        }
        if(profession == "Priest"){
            hp = 8+statsBonus[2];
            power = 8+statsBonus[5]; 
        }
        if(profession == "Necro"){
            hp = 10+statsBonus[2];
            power = 10+statsBonus[5]; 
        }
    }
}