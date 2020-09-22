import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SaveGames{
    //saveload.saveCurrentGame(builder.style, builder.race, builder.profession, builder.stats[0], builder.stats[1], builder.stats[2], builder.stats[3],builder.stats[4], builder.stats[5], builder.hp, builder.power, builder.currentXP, builder.lvl, builder.nextXP);
    public void saveCurrentGame(String style, String race, String profession, int str, int con, int dex, int qui, int iq, int spr, int hp, int pow, int curXP, int lvl, int nextXP){
        try{
            FileWriter myWriter = new FileWriter("SavedGames.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(style+","+race+","+profession+","+str+","+con+","+dex+","+qui+","+iq+","+spr+","+hp+","+pow+","+curXP+","+lvl+","+nextXP+"\r");
            pWriter.close();
            System.out.print("Current Game Saved");
        }catch(IOException e){
            e.printStackTrace();
        }   
    }
}//20