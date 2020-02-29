import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListStudent extends Container{
    public static JTextArea text;
    private JButton buttonLIST;
    private JButton buttonBACK;
    public ListStudent(){
        setSize(500,400);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 50, 300, 100);
        add(text);

        buttonLIST = new JButton("LIST STUDENT");
        buttonLIST.setBounds(90, 180, 145, 30);
        buttonLIST.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                PackageData listPd = new PackageData("LIST");
                Client.connect(listPd);
            }

        });
        add(buttonLIST);

        buttonBACK = new JButton("BACK");
        buttonBACK.setBounds(245, 180, 145, 30);
        buttonBACK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                Client.frame.listGUI.setVisible(false);
                Client.frame.menu.setVisible(true);
                Client.frame.repaint();
            }

        });
        add(buttonBACK);


    }

}