import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedWriter;
//import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.Scanner;
import java.util.Random;
//import javafx.application.Application;

public class ASCENSION implements ActionListener{
     CreateMainGUI maingui = new CreateMainGUI();
     CreateNewGameGUI newgamegui = new CreateNewGameGUI();
     CreateSavedGameGUI savegamegui = new CreateSavedGameGUI();
     CreateGameArea gamearea = new CreateGameArea();
     StatBuilder builder = new StatBuilder();
     StatBuilder enemy = new StatBuilder();

     JFrame window = new JFrame("Ascension v4");

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
                         builder.selectStyle(1);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.insane.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(2);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.diabolic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(3);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.elusive.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(4);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.wise.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(5);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.stout.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(6);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.pure.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(7);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.psionic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(8);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.mystical.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(9);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.deadly.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectStyle(10);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.human.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(1);
                         updateNewGameGUI();
                    }
			}
          );
          newgamegui.kobold.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(2);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.dwarf.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(3);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.undead.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(4);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.elven.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(5);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.troll.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(6);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.ogre.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(7);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.draconic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(8);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.atlantean.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(9);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.giant.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectRace(10);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.warrior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(1);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.priest.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(2);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.rogue.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(3);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.necro.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(4);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.mage.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(5);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.ravager.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(6);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.paladin.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(7);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.pyro.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(8);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.jugger.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(9);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.dervish.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         builder.selectProfession(10);
                         updateNewGameGUI();
				}
			}
          );
          newgamegui.strN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[0] != 0){
                              builder.statsAddition[0] -= 1;
                              builder.stats[0] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.strP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[0] += 1;
                              builder.stats[0] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.staN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[1] != 0){
                              builder.statsAddition[1] -= 1;
                              builder.stats[1] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.staP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[1] += 1;
                              builder.stats[1] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.dexN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[2] != 0){
                              builder.statsAddition[2] -= 1;
                              builder.stats[2] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.dexP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[2] += 1;
                              builder.stats[2] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.quiN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[3] != 0){
                              builder.statsAddition[3] -= 1;
                              builder.stats[3] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.quiP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[3] += 1;
                              builder.stats[3] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.iqN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[4] != 0){
                              builder.statsAddition[4] -= 1;
                              builder.stats[4] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.iqP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[4] += 1;
                              builder.stats[4] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.sprN.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.statsAddition[5] != 0){
                              builder.statsAddition[5] -= 1;
                              builder.stats[5] -= 1;
                              builder.bonusPoints += 1;
                              newgamegui.extraPts.setText("Extra Points ; "+builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.sprP.addActionListener(
               new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.bonusPoints>0){
                              builder.statsAddition[5] += 1;
                              builder.stats[5] += 1;
                              builder.bonusPoints -= 1;
                              newgamegui.extraPts.setText("Extra Points : " + builder.bonusPoints);
                              updateNewGameGUI();
                         }
				}
			}
          );
          newgamegui.start.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                         if(builder.style !="none" && builder.race !="none" && builder.profession !="none"){
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
                    gamearea.reDrawMap(-100, 100);
                    createEnemy();
				movement();
			}
		});
		ap.put("Move West", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
                    System.out.print("West");
                    gamearea.reDrawMap(100, -100);
                    createEnemy();
				movement();
			}
		});	
		ap.put("Move North", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
                    System.out.print("North");
                    gamearea.reDrawMap(100, 100);
                    createEnemy();
				movement();
			}
		});	
		ap.put("Move South", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
                    System.out.print("South");
                    gamearea.reDrawMap(-100, -100);
                    createEnemy();
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

    public void saveCurrentGame(){
        try{
            FileWriter myWriter = new FileWriter("SavedGames.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(builder.style+","+builder.race+","+builder.profession+","+builder.stats[0]+","+builder.stats[1]+","+builder.stats[2]+","+builder.stats[3]+","+builder.stats[4]+","+builder.stats[5]+","+builder.hp+","+builder.power+","+builder.currentXP+","+builder.lvl+","+builder.nextXP+"\r");
            pWriter.close();
            System.out.print("Current Game Saved");
        }catch(IOException e){
            e.printStackTrace();
        }   
    }

     public void updateNewGameGUI(){
          newgamegui.styleRaceClass.setText(builder.style+"     "+builder.race+"      "+builder.profession);
          newgamegui.strV.setText(": "+builder.stats[0]);
          newgamegui.strB.setText("+ "+builder.statsBonus[0]);
          newgamegui.staV.setText(": "+builder.stats[1]);
          newgamegui.staB.setText("+ "+builder.statsBonus[1]);
          newgamegui.dexV.setText(": "+builder.stats[2]);
          newgamegui.dexB.setText("+ "+builder.statsBonus[2]);
          newgamegui.quiV.setText(": "+builder.stats[3]);
          newgamegui.quiB.setText("+ "+builder.statsBonus[3]);
          newgamegui.iqV.setText(": "+builder.stats[4]);
          newgamegui.iqB.setText("+ "+builder.statsBonus[4]);
          newgamegui.sprV.setText(": "+builder.stats[5]);
          newgamegui.sprB.setText("+ "+builder.statsBonus[5]);
          newgamegui.hp.setText(newgamegui.life+builder.hp+"                       ");
          newgamegui.pow.setText(newgamegui.power+builder.power+"                      ");

          newgamegui.melee.setVisible(false);
          newgamegui.magic.setVisible(false);
          newgamegui.spark.setVisible(false);
          newgamegui.smite.setVisible(false);
          newgamegui.sweep.setVisible(false);
          newgamegui.lifetap.setVisible(false);
          if(builder.stats[0]>=0){
               newgamegui.melee.setVisible(true);
          }
          if(builder.stats[4]>=0){
               newgamegui.magic.setVisible(true);
          }
          if(builder.stats[4]>=5){
               newgamegui.spark.setVisible(true);
          }
          if(builder.stats[5]>=5){
               newgamegui.smite.setVisible(true);
          }
          if(builder.stats[0]>=5 && builder.stats[3]>=5){
               newgamegui.sweep.setVisible(true);
          }
          if(builder.stats[0]>=5 && builder.profession =="Necro"){
               newgamegui.lifetap.setVisible(true);
          }
     }

     public void createEnemy(){
          Random rand = new Random();

          int eliteChance = rand.nextInt(100);
          int randomStyle = rand.nextInt(6);
          int randomRace = rand.nextInt(9);
          int randomProfession = rand.nextInt(6);

          enemy.selectStyle(randomStyle);
          enemy.selectRace(randomRace);
          enemy.selectProfession(randomProfession);
          
          if(eliteChance<= 75){
               enemy.elite = "";
          }else if(eliteChance>= 76 && eliteChance <= 91){
               enemy.elite = "Elite";
          }else if(eliteChance>= 92 && eliteChance <= 99){
               enemy.elite = "Champion";
          }else{
               enemy.elite = "Boss";
          }
          System.out.println(enemy.elite+" "+enemy.style+" "+enemy.race+" "+enemy.profession);
     }
}//638