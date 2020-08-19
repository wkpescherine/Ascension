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
                    setStats("Divine",0,1,1,1,2,3,4);
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
                    if(attributes[0]!="Style" && attributes[1]!="Race" && attributes[2]!="Class"){
                        gamearea.gamePlay.setVisible(true);
                        newgamegui.newGame.setVisible(false); 
                        drawMap();
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

        //Thi si the complete game window section
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
        styleRaceClass.setText(attributes[0]+"     "+attributes[1]+"      "+attributes[2]);
        str.setText(strength+ stats[0]+"     +"+statsBonus[0] +"   ");
        sta.setText(stamina+ stats[1]+"     +"+statsBonus[1] +"   ");
        dex.setText(dexterity+ stats[2]+"     +"+statsBonus[2] +"   ");
        qui.setText(quickness+ stats[3]+"     +"+statsBonus[3] +"   ");
        iq.setText(intelligence+ stats[4]+"     +"+statsBonus[4] +"   ");
        spr.setText(spirit+ stats[5]+"     +"+statsBonus[5] +"              ");
        hp.setText(life+stats[6]+"                       ");
        pow.setText(power+stats[7]+"                       ");
    }

    
    
    public void calculateBonuses(){
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
    }

    public void setHpPower(){
        if(attributes[2]== "Warrior"){
            stats[6] = 12+statsBonus[2];
        }
        if(attributes[2]== "Rogue"){
            stats[6] = 8+statsBonus[2];
        }
        if(attributes[2]== "Mage"){
            stats[6] = 4+statsBonus[2];
            stats[7] = 12+statsBonus[4]; 
        }
        if(attributes[2]== "Priest"){
            stats[6] = 8+statsBonus[2];
            stats[7] = 8+statsBonus[5]; 
        }
        if(attributes[2]== "Necro"){
            stats[6] = 10+statsBonus[2];
            stats[7] = 10+statsBonus[5]; 
        }
    }

    public void displaySkills(){
        melee.setVisible(false);
        magic.setVisible(false);
        spark.setVisible(false);
        smite.setVisible(false);
        sweep.setVisible(false);
        lifetap.setVisible(false);
        if(stats[0]>=0){
            melee.setVisible(true);
        }
        if(stats[4]>=0){
            magic.setVisible(true);
        }
        if(stats[4]>=5){
            spark.setVisible(true);
        }
        if(stats[5]>=5){
            smite.setVisible(true);
        }
        if(stats[0]>=5 && stats[3]>=5){
            sweep.setVisible(true);
        }
        if(stats[0]>=5 && attributes[2]=="Necro"){
            lifetap.setVisible(true);
        }
    }

    public void saveCurrentGame(){
        try{
            FileWriter myWriter = new FileWriter("ascensionSavedGames.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(charstat+","+attributes[1]+","+attributes[2]+","+stats[0]+","+stats[1]+","+stats[2]+","+stats[3]+","+stats[4]+","+stats[5]+","+stats[6]+","+stats[7]+"\r");
            pWriter.close();
            System.out.print("Current Game Saved");
        }catch(IOException e){
            e.printStackTrace();
        }   
    }
}