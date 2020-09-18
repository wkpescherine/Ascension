import java.lang.String;

public class StatBuilder{
    int [][] statsTemp = new int[3][6];
    int [] stats = {0,0,0,0,0,0};
    int [] statsBonus = {0,0,0,0,0,0};
    int [] statsAddition = {0,0,0,0,0,0};
    int bonusPoints = 12;
    String elite = "";
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

    public void selectStyle(int choiceS){
        switch(choiceS){
            case 1:
                setStats("Divine",0,1,1,1,2,3,4);
                break;
            case 2:
                setStats("Insane",0,2,1,2,4,3,0);
                break;
            case 3:
                setStats("Diabolic",0,5,3,1,2,1,0);
                break; 
            case 4:
                setStats("Elusive",0,1,2,5,4,0,0);
                break;
            case 5:
                setStats("Wise",0,1,1,3,2,5,1);
                break; 
            case 6:
                setStats("Stout",0,2,6,2,2,0,0);
                break; 
            case 7:
                setStats("Pure",0,3,3,2,2,0,2);
                break;
            case 8:
                setStats("Psionic",0,1,1,1,1,8,0);
                break;
            case 9:
                setStats("Mystical",0,0,0,2,4,6,0);
                break;
            case 10:
                setStats("Deadly",0,4,0,8,0,0,0);
                break; 
        }
    }

    public void selectRace(int choiceR){
        switch(choiceR){
            case 1:
                setStats("Human",1,2,2,2,2,2,2);
                break;
            case 2:
                setStats("Kobold",1,1,1,4,4,1,1);
                break;
            case 3:
                setStats("Dwarven",1,2,4,1,1,1,1);
                break;
            case 4:
                setStats("Undead",1,2,5,1,1,0,3);
                break;
            case 5:
                setStats("Elven",1,1,1,2,2,4,2);
                break;
            case 6:
                setStats("Troll",1,2,6,2,2,0,0);
                break;
            case 7:
                setStats("Ogre",1,6,2,2,2,0,0);
                break;
            case 8:
                setStats("Draconic",1,3,3,2,2,2,0);
                break;
        }
    }

    public void selectProfession(int choiceP){
        switch(choiceP){
            case 1:
                setStats("Warrior",2,4,4,3,1,0,0);
                break;
            case 2:
                setStats("Priest",2,1,2,1,3,1,4);
                break;
            case 3:
                setStats("Rogue",2,2,1,4,5,0,0);
                break;
            case 4:
                setStats("Necro",2,3,3,1,1,0,4);
                break;
            case 5:
                setStats("Mage",2,0,0,1,3,5,3);
                break;
        }
    }

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
}//138