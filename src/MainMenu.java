
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MainMenu extends Container{
    public JButton add;
    public JButton list;
    public JButton exit;

    public MainMenu() {
        setSize(500,400);
        setLayout(null);

        add = new JButton("ADD");
        add.setBounds(100, 80, 300, 30);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Client.frame.menu.setVisible(false);
                Client.frame.addGUI.setVisible(true);
                Client.frame.repaint();
            }
        });
        add(add);

        list = new JButton("LIST");
        list.setBounds(100, 120, 300, 30);
        list.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Client.frame.menu.setVisible(false);
                Client.frame.listGUI.setVisible(true);
                Client.frame.repaint();
            }
        });
        add(list);

        exit = new JButton("EXIT");
        exit.setBounds(100, 160, 300, 30);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);

            }
        });
        add(exit);
    }
}
