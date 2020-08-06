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
//import javafx.application.Application;

public class ASCENSION implements ActionListener{
    String [] attributes = {"Style", "Race", "Class", "Name"};
    int [][] statsTemp = new int[3][6];
    int [] stats = new int[8];
    int [] statsBonus = new int[8];
    int coordx = 300;
    int coordy = 250;

    String strength = "Strength      : ";
    String stamina = "Stamina        : ";
    String dexterity = "Dexterity     : ";
    String quickness = "Quickmess      : ";
    String intelligence = "Intelligence   : ";
    String spirit = "Spirit         : ";
    String life = "Life       :";
    String power = "Power    : ";

    JFrame window = new JFrame("Ascension v1");
    JPanel main = new JPanel();
    JPanel savedGames = new JPanel();
    JPanel newGame = new JPanel();
    JPanel selectRace = new JPanel();
    JPanel selectStyle = new JPanel();
    JPanel selectClass = new JPanel();
    JPanel bonusSection = new JPanel();
    JPanel skillsSection = new JPanel();
    JPanel gamePlay = new JPanel();
    JPanel dungeonMap = new JPanel();
    JPanel lifeArea = new JPanel();
    JPanel skillsMenu = new JPanel();
    JPanel powerArea = new JPanel();
    JPanel gameMenuOptions = new JPanel();
    JPanel charView = new JPanel();
    JPanel inventoryView = new JPanel();
    JButton startSavedGame = new JButton("Saved Game");
    JButton startNewGame = new JButton("New Game");
    JButton backToMain = new JButton("Back to Main");
    JButton backToMain2 = new JButton("Back to Main");
    JButton start = new JButton("Start Game");
    JButton human = new JButton("Human");
    JButton dwarf = new JButton("Dwarven");
    JButton elven = new JButton("Elven");
    JButton kobold = new JButton("Kobold");
    JButton undead = new JButton("Undead");
    JButton troll = new JButton("Troll");
    JButton ogre = new JButton("Ogre");
    JButton draconic = new JButton("Draconis");
    JButton insane = new JButton("Insane");
    JButton divine = new JButton("Divine");
    JButton elusive = new JButton("Elusive");
    JButton diabolic = new JButton("Diabolical");
    JButton wise = new JButton("Wise");
    JButton warrior = new JButton("Warrior");
    JButton rogue = new JButton("Rogue");
    JButton mage = new JButton("Mage");
    JButton priest = new JButton("Priest");
    JButton necro = new JButton("Necro");
    JButton melee = new JButton("melee");
    JButton magic = new JButton("magic");
    JButton spark = new JButton("spark");
    JButton smite = new JButton("smite");
    JButton sweep = new JButton("sweep");
    JButton lifetap = new JButton("lifetap");
    JButton slot1 = new JButton("S1");
    JButton slot2 = new JButton("S2");
    JButton slot3 = new JButton("S3");
    JButton slot4 = new JButton("S4");
    JButton slot5 = new JButton("S5");
    JButton slot6 = new JButton("S6");
    JButton slot7 = new JButton("S7");
    JButton slot8 = new JButton("S8");
    JButton slot9 = new JButton("S9");
    JButton slot0 = new JButton("S0");
    JButton gameMenu = new JButton("Menu");
    JButton charSheet = new JButton("CS");
    JButton inventory = new JButton("INV");
    JButton gameMenuOptionSave = new JButton("Save");
    JButton gameMenuOptionReturn = new JButton("Return");
    JButton gameMenuOptionQuit = new JButton("Quit");
    JButton closeCharView = new JButton("Close");
    JButton closeInventoryView = new JButton("Close");
    JLabel styleRaceClass = new JLabel(attributes[0]+attributes[1]+attributes[2]);
    JLabel str = new JLabel(strength);
    JLabel dex = new JLabel(dexterity);
    JLabel qui = new JLabel(quickness);
    JLabel iq = new JLabel(intelligence);
    JLabel sta = new JLabel(stamina);
    JLabel spr = new JLabel(spirit);
    JLabel hp = new JLabel(life);
    JLabel pow = new JLabel(power);
    JLabel savedGameLabel1 = new JLabel("Game slot 1");
    JLabel savedGameLabel2 = new JLabel("Game slot 2");
    JLabel savedGameLabel3 = new JLabel("Game slot 3");
    JLabel savedGameLabel4 = new JLabel("Game slot 4");
    ImageIcon imageTile1 = new ImageIcon(getClass().getResource("sampleTile.png"));
    JLabel imageMap1 = new JLabel(imageTile1);
    JLabel imageMap2 = new JLabel(imageTile1);
    JLabel imageMap3 = new JLabel(imageTile1);
    JLabel imageMap4 = new JLabel(imageTile1);

    int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

    ASCENSION(){
        movement();

        main.setLayout(null);
        main.setPreferredSize(new Dimension(780,580));
        main.setBackground(Color.BLACK);
        startNewGame.setBounds(200,290,100,20);
        startNewGame.addActionListener(this);
        startSavedGame.setBounds(400,290,100,20);
        startSavedGame.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    main.setVisible(false);
                    savedGames.setVisible(true);
                    getSavedGames();
				}
			}   
        );
        main.add(startNewGame);
        main.add(startSavedGame);
        main.setVisible(true);

        newGame.setLayout(new FlowLayout());
        newGame.setPreferredSize(new Dimension(780,580));
        selectStyle.setPreferredSize(new Dimension(250,170));
        selectStyle.add(divine);
        divine.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Divine",0,1,1,1,2,3,4);
				}
			}
        );
        selectStyle.add(insane);
        insane.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Insane",0,2,1,2,4,3,0);
				}
			}
        );
        selectStyle.add(diabolic);
        diabolic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Diabolic",0,5,3,1,2,1,0);
				}
			}
        );
        selectStyle.add(elusive);
        elusive.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Elusive",0,1,2,5,4,0,0);
				}
			}
        );
        selectStyle.add(wise);
        wise.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Wise",0,1,1,3,2,5,1);
				}
			}
        );
        selectRace.setPreferredSize(new Dimension(250,170));
        selectRace.add(human);
        human.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Human",1,2,2,2,2,2,2);
				}
			}
        );
        selectRace.add(kobold);
        kobold.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Kobold",1,1,1,4,4,1,1);
				}
			}
        );
        selectRace.add(dwarf);
        dwarf.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Dwarven",1,2,4,1,1,1,1);
				}
			}
        );
        selectRace.add(undead);
        undead.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Undead",1,2,5,1,1,0,3);
				}
			}
        );
        selectRace.add(elven);
        elven.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Elven",1,1,1,2,2,4,2);
				}
			}
        );
        selectRace.add(troll);
        troll.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Troll",1,2,6,2,2,0,0);
				}
			}
        );
        selectRace.add(ogre);
        ogre.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Ogre",1,6,2,2,2,0,0);
				}
			}
        );
        selectRace.add(draconic);
        draconic.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Draconic",1,3,3,2,2,2,0);
				}
			}
        );
        selectClass.setPreferredSize(new Dimension(250,170));
        selectClass.add(warrior);
        warrior.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Warrior",2,4,4,3,1,0,0);
				}
			}
        );
        selectClass.add(priest);
        priest.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Priest",2,1,2,1,3,1,4);
				}
			}
        );
        selectClass.add(rogue);
        rogue.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Rogue",2,2,1,4,5,0,0);
				}
			}
        );
        selectClass.add(necro);
        necro.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Necro",2,3,3,1,1,0,4);
				}
			}
        );
        selectClass.add(mage);
        mage.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    setStats("Mage",2,0,0,1,3,5,3);
				}
			}
        );
        backToMain.setBounds(200,100,100,20);
        backToMain.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    newGame.setVisible(false);
                    main.setVisible(true);
				}
			}
        );
        start.setBounds(200,300,100,20);
        start.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    if(attributes[0]!="Style" && attributes[1]!="Race" && attributes[2]!="Class"){
                        gamePlay.setVisible(true);
                        newGame.setVisible(false); 
                        drawMap();
                    }
				}
			}
        ); 
        bonusSection.setPreferredSize(new Dimension(250,350));
        bonusSection.setLayout(new FlowLayout());
        bonusSection.add(styleRaceClass);
        bonusSection.add(str);
        bonusSection.add(sta);
        bonusSection.add(dex);
        bonusSection.add(qui);
        bonusSection.add(iq);
        bonusSection.add(spr);
        bonusSection.add(hp);
        bonusSection.add(pow);
        skillsSection.setPreferredSize(new Dimension(500,350));
        skillsSection.setLayout(new FlowLayout());
        melee.setVisible(false);
        magic.setVisible(false);
        spark.setVisible(false);
        smite.setVisible(false);
        sweep.setVisible(false);
        lifetap.setVisible(false);
        skillsSection.add(melee);
        skillsSection.add(magic);
        skillsSection.add(spark);
        skillsSection.add(smite);
        skillsSection.add(sweep);
        skillsSection.add(lifetap);        
        newGame.setBackground(Color.BLACK);
        newGame.add(selectStyle);
        newGame.add(selectRace);
        newGame.add(selectClass);
        newGame.add(bonusSection);
        newGame.add(skillsSection);
        newGame.add(backToMain);
        newGame.add(start);
        newGame.setVisible(false);

        savedGames.setLayout(null);
        savedGames.setPreferredSize(new Dimension(780,580));
        backToMain2.setBounds(200,500,100,20);
        backToMain2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    savedGames.setVisible(false);
                    main.setVisible(true);
				}
			}
        );
        savedGameLabel1.setForeground(Color.WHITE);
        savedGameLabel1.setBounds(20,100,300,20);
        savedGameLabel2.setForeground(Color.WHITE);
        savedGameLabel2.setBounds(20,200,300,20);
        savedGameLabel3.setForeground(Color.WHITE);
        savedGameLabel3.setBounds(20,300,300,20);
        savedGameLabel4.setForeground(Color.WHITE);
        savedGameLabel4.setBounds(20,400,300,20);
        savedGames.setBackground(Color.BLACK);
        savedGames.add(backToMain2);
        savedGames.add(savedGameLabel1);
        savedGames.add(savedGameLabel2);
        savedGames.add(savedGameLabel3);
        savedGames.add(savedGameLabel4);
        savedGames.setVisible(false);

        gamePlay.setLayout(new FlowLayout());
        gamePlay.setPreferredSize(new Dimension(780,580));
        gamePlay.setBackground(Color.BLACK);
        dungeonMap.setPreferredSize(new Dimension(770,460));
        dungeonMap.setLayout(null);
        dungeonMap.add(imageMap1);
        dungeonMap.add(imageMap2);
        dungeonMap.add(imageMap3);
        dungeonMap.add(imageMap4);
        dungeonMap.add(gameMenuOptions);
        dungeonMap.add(charView);
        dungeonMap.add(inventoryView);
        charView.setVisible(false);
        charView.setBounds(200,50,100,500);
        charView.setPreferredSize(new Dimension(200,400));
        charView.add(closeCharView);
        closeCharView.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(false);
                    charView.setVisible(false);
				}
			}
        );
        inventoryView.setVisible(false);
        inventoryView.setBounds(200,50,100,500);
        inventoryView.setPreferredSize(new Dimension(500,400));
        inventoryView.add(closeInventoryView);
        closeInventoryView.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    inventoryView.setVisible(false);
                }
            }
        );
        lifeArea.setPreferredSize(new Dimension(100,100));
        skillsMenu.setPreferredSize(new Dimension(560,100));
        slot1.setPreferredSize(new Dimension(50,50));
        slot2.setPreferredSize(new Dimension(50,50));
        slot3.setPreferredSize(new Dimension(50,50));
        slot4.setPreferredSize(new Dimension(50,50));
        slot5.setPreferredSize(new Dimension(50,50));
        slot6.setPreferredSize(new Dimension(50,50));
        slot7.setPreferredSize(new Dimension(50,50));
        slot8.setPreferredSize(new Dimension(50,50));
        slot9.setPreferredSize(new Dimension(50,50));
        slot0.setPreferredSize(new Dimension(50,50));
        gameMenu.setPreferredSize(new Dimension(50,50));
        gameMenu.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(true);
                    charView.setVisible(false);
                    inventoryView.setVisible(false);
				}
			}
		);
        charSheet.setPreferredSize(new Dimension(50,50));
        charSheet.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    charView.setVisible(true);
                    gameMenuOptions.setVisible(false);
				}
			}
		);
        inventory.setPreferredSize(new Dimension(50,50));
        inventory.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(false);
                    inventoryView.setVisible(true);
				}
			}
		);
        skillsMenu.add(slot1);
        skillsMenu.add(slot2);
        skillsMenu.add(slot3);
        skillsMenu.add(slot4);
        skillsMenu.add(slot5);
        skillsMenu.add(slot6);
        skillsMenu.add(slot7);
        skillsMenu.add(slot8);
        skillsMenu.add(slot9);
        skillsMenu.add(slot0);
        skillsMenu.add(gameMenu);
        skillsMenu.add(charSheet);
        skillsMenu.add(inventory);
        powerArea.setPreferredSize(new Dimension(100,100));
        gameMenuOptions.setPreferredSize(new Dimension(120,200));
        gameMenuOptions.setBounds(200,50,100,500);
        gameMenuOptions.setPreferredSize(new Dimension(200,400));
        gameMenuOptions.add(gameMenuOptionSave);
        gameMenuOptions.add(gameMenuOptionReturn);
        gameMenuOptions.add(gameMenuOptionQuit);
        gameMenuOptionSave.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(false);
                    saveCurrentGame();
				}
			}
        );
        gameMenuOptionReturn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(false);
				}
			}
        );
        gameMenuOptionQuit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    gameMenuOptions.setVisible(false);
                    main.setVisible(true);
				}
			}
        );
        gameMenuOptions.setVisible(false);
        gamePlay.add(dungeonMap);
        gamePlay.add(lifeArea);
        gamePlay.add(skillsMenu);
        gamePlay.add(powerArea);
        gamePlay.setVisible(false);

        window.add(main);
        window.add(newGame);
        window.add(savedGames);
        window.add(gamePlay);
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
		main.setVisible(false);
        newGame.setVisible(true);
        setStats("Name",0,0,0,0,0,0,0);
        styleRaceClass.setText("");
    }
    
    public void setStats(String choice, int a, int b, int c, int d, int e, int f , int g){
        attributes [a] = choice;
        statsTemp [a][0] = b;
        statsTemp [a][1] = c;
        statsTemp [a][2] = d;
        statsTemp [a][3] = e;
        statsTemp [a][4] = f;
        statsTemp [a][5] = g;
        stats [0] = statsTemp [0][0] + statsTemp [1][0]+statsTemp [2][0];
        stats [1] = statsTemp [0][1] + statsTemp [1][1]+statsTemp [2][1];
        stats [2] = statsTemp [0][2] + statsTemp [1][2]+statsTemp [2][2];
        stats [3] = statsTemp [0][3] + statsTemp [1][3]+statsTemp [2][3];
        stats [4] = statsTemp [0][4] + statsTemp [1][4]+statsTemp [2][4];
        stats [5] = statsTemp [0][5] + statsTemp [1][5]+statsTemp [2][5];
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

    public void movement(){
		InputMap im = gamePlay.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Move North");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Move South");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Move West");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Move East");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), "Slot 1");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), "Slot 2");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), "Slot 3");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), "Slot 4");
		ActionMap ap = gamePlay.getActionMap();
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
            pWriter.write(attributes[0]+","+attributes[1]+","+attributes[2]+","+stats[0]+","+stats[1]+","+stats[2]+","+stats[3]+","+stats[4]+","+stats[5]+","+stats[6]+","+stats[7]+"\r");
            pWriter.close();
            System.out.print("Current Game Saved");
        }catch(IOException e){
            e.printStackTrace();
        }   
    }

    public void drawMap(){
        imageMap1.setBounds(100,100,50,50);
        imageMap2.setBounds(100,200,50,50);
        imageMap3.setBounds(200,100,50,50);
        imageMap4.setBounds(200,200,50,50);
    }

    public void getSavedGames(){
        try{
            File myFile = new File("ascensionSavedGames.txt");
            Scanner myReader = new Scanner(myFile);
            int slotNumber = 1;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String [] dataArray = data.split(",",8);
                String savedGame1 = dataArray[0]+" "+dataArray[1]+" "+dataArray[2];
                System.out.print(slotNumber + savedGame1);
                if(slotNumber == 1 ){
                    savedGameLabel1.setText(savedGame1);
                }
                if(slotNumber == 2 ){
                    savedGameLabel2.setText(savedGame1);
                }
                if(slotNumber == 3 ){
                    savedGameLabel3.setText(savedGame1);
                }
                if(slotNumber == 4 ){
                    savedGameLabel4.setText(savedGame1);
                }
                slotNumber+=1;
            }
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}