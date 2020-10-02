import java.awt.*;
import javax.swing.*;

public class CharViewPanel{
    JPanel charMain = new JPanel();
    JLabel charStyle = new JLabel("NONE");
    JLabel charRace = new JLabel("NONE");
    JLabel charProf = new JLabel("NONE");
    JLabel strLabel = new JLabel("Strength     :");
    JLabel conLabel = new JLabel("Constitution :");
    JLabel dexLabel = new JLabel("Dexterity    :");
    JLabel quiLabel = new JLabel("Quickness    :");
    JLabel intLabel = new JLabel("Intelligence :");
    JLabel sprLabel = new JLabel("Spirit       :");
    JLabel strValue = new JLabel("0");
    JLabel conValue = new JLabel("0");
    JLabel dexValue = new JLabel("0");
    JLabel quiValue = new JLabel("0");
    JLabel intValue = new JLabel("0");
    JLabel sprValue = new JLabel("0");
    JLabel strBonus = new JLabel("+0");
    JLabel conBonus = new JLabel("+0");
    JLabel dexBonus = new JLabel("+0");
    JLabel quiBonus = new JLabel("+0");
    JLabel intBonus = new JLabel("+0");
    JLabel sprBonus = new JLabel("+0");

    CharViewPanel(){
        charMain.setLayout(new FlowLayout());
        charMain.setPreferredSize(new Dimension(180,360));
        charMain.add(charStyle);
        charMain.add(charRace);
        charMain.add(charProf);
        charMain.add(strLabel);
        charMain.add(conLabel);
        charMain.add(dexLabel);
        charMain.add(quiLabel);
        charMain.add(intLabel);
        charMain.add(sprLabel);
        charMain.add(strValue);
        charMain.add(conValue);
        charMain.add(dexValue);
        charMain.add(quiValue);
        charMain.add(intValue);
        charMain.add(sprValue);
        charMain.add(strBonus);
        charMain.add(conBonus);
        charMain.add(dexBonus);
        charMain.add(quiBonus);
        charMain.add(intBonus);
        charMain.add(sprBonus);
    }
}//53