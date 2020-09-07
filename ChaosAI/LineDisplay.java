import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

public class LineDisplay{
    String [] data = {"...........This is the Html Section...........","","","","","","","","","","","","","",""};

    JPanel main = new JPanel();
    JLabel lineLabel = new JLabel();
    JList list = new JList<String>(data);
    //JScrollPane listScroller = new JScrollPane(list);

    LineDisplay(){
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        //list.setPreferredSize(new Dimension(250,500));
        //JScrollPane listScroller = new JScrollPane(list);
        //listScroller.setPreferredSize(new Dimension(250, 80));

        main.add(list);
        main.setLayout(new FlowLayout());
        main.setPreferredSize(new Dimension(400,580));
        main.setBackground(Color.WHITE);
    }
}