import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.Scanner;
import javafx.application.Application;

public class ASCENSION implements ActionListener{
    CreateMainGUI maingui = new CreateMainGUI();
    CreateNewGameGUI newgamegui = new CreateNewGameGUI();
    CreateSavedGameGUI savegamegui = new CreateSavedGameGUI();
    CreateGameArea gamearea = new CreateGameArea();
    CharStatSheet statsheet = new CharStatSheet();
    StatBuilder builder = new StatBuilder();

    JFrame window = new JFrame("Ascension v3");

    int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

    ASCENSION(){
        movement();

        //This is hte Main Section Actions
        maingui.startNewGame.addActionListener(this);
        maingui.startSavedGame.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    maingui.main.setVisible(false);
                    savegamegui.savedGames.setVisible(true);
                    getSavedGames();
				}
			}   
        );

        //This is the new Game Section Actions
        newgamegui.backToMain.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newgamegui.newGame.setVisible(false);
                    maingui.main.setVisible(true);
				}
			}
        );
        newgamegui.divine.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    builder.setStats("e,Divine,0,1,1,1,2,3,4");
				}
			}
        );
        newgamegui.insane.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Insane",0,2,1,2,4,3,0);
				}
			}
        );
        newgamegui.diabolic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Diabolic",0,5,3,1,2,1,0);
				}
			}
        );
        newgamegui.elusive.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Elusive",0,1,2,5,4,0,0);
				}
			}
        );
        newgamegui.wise.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Wise",0,1,1,3,2,5,1);
				}
			}
        );
        newgamegui.human.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Human",1,2,2,2,2,2,2);
				}
			}
        );
        newgamegui.kobold.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Kobold",1,1,1,4,4,1,1);
				}
			}
        );
        newgamegui.dwarf.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Dwarven",1,2,4,1,1,1,1);
				}
			}
        );
        newgamegui.undead.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Undead",1,2,5,1,1,0,3);
				}
			}
        );
        newgamegui.elven.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Elven",1,1,1,2,2,4,2);
				}
			}
        );
        newgamegui.troll.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Troll",1,2,6,2,2,0,0);
				}
			}
        );
        newgamegui.ogre.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Ogre",1,6,2,2,2,0,0);
				}
			}
        );
        newgamegui.draconic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Draconic",1,3,3,2,2,2,0);
				}
			}
        );
        newgamegui.warrior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Warrior",2,4,4,3,1,0,0);
				}
			}
        );
        newgamegui.priest.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Priest",2,1,2,1,3,1,4);
				}
			}
        );
        newgamegui.rogue.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Rogue",2,2,1,4,5,0,0);
				}
			}
        );
        newgamegui.necro.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Necro",2,3,3,1,1,0,4);
				}
			}
        );
        newgamegui.mage.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Mage",2,0,0,1,3,5,3);
				}
			}
        );
        newgamegui.start.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    if(statsheet.style !="none" && statsheet.race !="none" && statsheet.profession !="none"){
                        gamearea.gamePlay.setVisible(true);
                        newgamegui.newGame.setVisible(false);                     
                    }
				}
			}
        ); 
        
        //This is the saved games Section Actions
        savegamegui.backToMain2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    savegamegui.savedGames.setVisible(false);
                    maingui.main.setVisible(true);
				}
			}
        );

        //This is the Game Play Section Actions
        gamearea.closeCharView.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(false);
                    gamearea.charView.setVisible(false);
				}
			}
        );
        gamearea.closeInventoryView.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    gamearea.inventoryView.setVisible(false);
                }
            }
        );
        gamearea.gameMenu.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(true);
                    gamearea.charView.setVisible(false);
                    gamearea.inventoryView.setVisible(false);
				}
			}
		);
        gamearea.charSheet.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.charView.setVisible(true);
                    gamearea.gameMenuOptions.setVisible(false);
				}
			}
		);
        gamearea.inventory.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(false);
                    gamearea.inventoryView.setVisible(true);
				}
			}
		);
        gamearea.gameMenuOptionSave.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(false);
                    saveCurrentGame();
				}
			}
        );
        gamearea.gameMenuOptionReturn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(false);
				}
			}
        );
        gamearea.gameMenuOptionQuit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gamearea.gameMenuOptions.setVisible(false);
                    maingui.main.setVisible(true);
				}
			}
        );

        //This is the complete game window section
        window.add(maingui.main);
        window.add(newgamegui.newGame);
        window.add(savegamegui.savedGames);
        window.add(gamearea.gamePlay);
        window.setLayout(new FlowLayout());
		window.setSize(800, 600);
		window.getContentPane().setBackground(Color.BLACK);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    } 

    public static void main(String args[]){
        ASCENSION ascension = new ASCENSION();
    }

    public void actionPerformed(ActionEvent e){
        maingui.main.setVisible(false);
        newgamegui.newGame.setVisible(true);
        setStats("Name",0,0,0,0,0,0,0);
        newgamegui.styleRaceClass.setText("");
    }

    public void getSavedGames(){
        try{
            File myFile = new File("/Users/wkpescherine/Desktop/Ascension/Version3/SavedGames.txt");
            Scanner myReader = new Scanner(myFile);
            int slotNumber = 1;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String [] dataArray = data.split(",",8);
                String savedGame1 = dataArray[0]+" "+dataArray[1]+" "+dataArray[2];
                System.out.print(slotNumber + savedGame1);
                if(slotNumber == 1 ){
                    savegamegui.savedGameLabel1.setText(savedGame1);
                }
                if(slotNumber == 2 ){
                    savegamegui.savedGameLabel2.setText(savedGame1);
                }
                if(slotNumber == 3 ){
                    savegamegui.savedGameLabel3.setText(savedGame1);
                }
                if(slotNumber == 4 ){
                    savegamegui.savedGameLabel4.setText(savedGame1);
                }
                slotNumber+=1;
            }
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

   public void movement(){
		InputMap im = gamearea.gamePlay.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Move North");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Move South");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Move West");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Move East");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), "Slot 1");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), "Slot 2");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), "Slot 3");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), "Slot 4");
		ActionMap ap = gamearea.gamePlay.getActionMap();
		ap.put("Move East", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
                System.out.print("East");
				movement();
			}
		});
		ap.put("Move West", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("West");
				movement();
			}
		});	
		ap.put("Move North", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("North");
				movement();
			}
		});	
		ap.put("Move South", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("South");
				movement();
			}
        });	
        ap.put("Slot 1", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("1");
				movement();
			}
        });	
        ap.put("Slot 2", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("2");
				movement();
			}
        });	
        ap.put("Slot 3", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("3");
				movement();
			}
        });	
        ap.put("Slot 4", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				System.out.print("4");
				movement();
			}
		});	
    }

    public void setStats(String choice, int a, int b, int c, int d, int e, int f , int g){
        if(a == 0){
            statsheet.style = choice;
        }
        if(a == 1){
            statsheet.race = choice;
        }
        if(a == 2){
            statsheet.profession = choice;
        }
        statsheet.statsTemp [a][0] = b;
        statsheet.statsTemp [a][1] = c;
        statsheet.statsTemp [a][2] = d;
        statsheet.statsTemp [a][3] = e;
        statsheet.statsTemp [a][4] = f;
        statsheet.statsTemp [a][5] = g;
        statsheet.stats [0] = statsheet.statsTemp [0][0] + statsheet.statsTemp [1][0]+statsheet.statsTemp [2][0];
        statsheet.stats [1] = statsheet.statsTemp [0][1] + statsheet.statsTemp [1][1]+statsheet.statsTemp [2][1];
        statsheet.stats [2] = statsheet.statsTemp [0][2] + statsheet.statsTemp [1][2]+statsheet.statsTemp [2][2];
        statsheet.stats [3] = statsheet.statsTemp [0][3] + statsheet.statsTemp [1][3]+statsheet.statsTemp [2][3];
        statsheet.stats [4] = statsheet.statsTemp [0][4] + statsheet.statsTemp [1][4]+statsheet.statsTemp [2][4];
        statsheet.stats [5] = statsheet.statsTemp [0][5] + statsheet.statsTemp [1][5]+statsheet.statsTemp [2][5];
        displaySkills();
        calculateBonuses();
        setHpPower();
        newgamegui.styleRaceClass.setText(statsheet.style+"     "+statsheet.race+"      "+statsheet.profession);
        newgamegui.str.setText(newgamegui.strength+ statsheet.stats[0]+"     +"+statsheet.statsBonus[0] +"   ");
        newgamegui.sta.setText(newgamegui.stamina+ statsheet.stats[1]+"     +"+statsheet.statsBonus[1] +"   ");
        newgamegui.dex.setText(newgamegui.dexterity+ statsheet.stats[2]+"     +"+statsheet.statsBonus[2] +"   ");
        newgamegui.qui.setText(newgamegui.quickness+ statsheet.stats[3]+"     +"+statsheet.statsBonus[3] +"   ");
        newgamegui.iq.setText(newgamegui.intelligence+ statsheet.stats[4]+"     +"+statsheet.statsBonus[4] +"   ");
        newgamegui.spr.setText(newgamegui.spirit+ statsheet.stats[5]+"     +"+statsheet.statsBonus[5] +"              ");
        newgamegui.hp.setText(newgamegui.life+statsheet.hp+"                       ");
        newgamegui.pow.setText(newgamegui.power+statsheet.power+"                      ");
        System.out.print(statsheet.race+statsheet.statsBonus[2]+statsheet.hp);
    }

    public void calculateBonuses(){
        for(int i = 0; i<6; i++){
            int bonusTemp = 0;
            int modBonus = 0;
            for(int x = 0; x<statsheet.stats[i]; x++){
                bonusTemp += x;
                if(bonusTemp+x < statsheet.stats[i]){
                    modBonus += 1;
                }
            }
            statsheet.statsBonus[i] = modBonus;
        }
    }

    public void setHpPower(){
        if(statsheet.profession == "Warrior"){
            statsheet.hp = 12+statsheet.statsBonus[2];
        }
        if(statsheet.profession == "Rogue"){
            statsheet.hp = 8+statsheet.statsBonus[2];
        }
        if(statsheet.profession == "Mage"){
            statsheet.hp = 4+statsheet.statsBonus[2];
            statsheet.power = 12+statsheet.statsBonus[4]; 
        }
        if(statsheet.profession == "Priest"){
            statsheet.hp = 8+statsheet.statsBonus[2];
            statsheet.power = 8+statsheet.statsBonus[5]; 
        }
        if(statsheet.profession == "Necro"){
            statsheet.hp = 10+statsheet.statsBonus[2];
            statsheet.power = 10+statsheet.statsBonus[5]; 
        }
    }

    public void displaySkills(){
        newgamegui.melee.setVisible(false);
        newgamegui.magic.setVisible(false);
        newgamegui.spark.setVisible(false);
        newgamegui.smite.setVisible(false);
        newgamegui.sweep.setVisible(false);
        newgamegui.lifetap.setVisible(false);
        if(statsheet.stats[0]>=0){
            newgamegui.melee.setVisible(true);
        }
        if(statsheet.stats[4]>=0){
            newgamegui.magic.setVisible(true);
        }
        if(statsheet.stats[4]>=5){
            newgamegui.spark.setVisible(true);
        }
        if(statsheet.stats[5]>=5){
            newgamegui.smite.setVisible(true);
        }
        if(statsheet.stats[0]>=5 && statsheet.stats[3]>=5){
            newgamegui.sweep.setVisible(true);
        }
        if(statsheet.stats[0]>=5 && statsheet.profession =="Necro"){
            newgamegui.lifetap.setVisible(true);
        }
    }

    public void saveCurrentGame(){
        try{
            FileWriter myWriter = new FileWriter("ascensionSavedGames.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(statsheet.style+","+statsheet.race+","+statsheet.prfession+","+statsheet.stats[0]+","+statsheet.stats[1]+","+statsheet.stats[2]+","+statsheet.stats[3]+","+statsheet.stats[4]+","+statsheet.stats[5]+","+statsheet.stats[6]+","+statsheet.stats[7]+"\r");
            pWriter.close();
            System.out.print("Current Game Saved");
        }catch(IOException e){
            e.printStackTrace();
        }   
    }
}