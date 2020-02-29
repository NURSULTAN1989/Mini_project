
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame extends JFrame{
    public static MainMenu menu;
    public static AddStudent addGUI;
    public static ListStudent listGUI;
    public MainFrame(){
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Application");
        setLayout(null);

        menu = new MainMenu();
        menu.setLocation(0,0);
        add(menu);

        addGUI = new AddStudent();
        addGUI.setLocation(0,0);
        addGUI.setVisible(false);
        add(addGUI);

        listGUI = new ListStudent();
        listGUI.setLocation(0,0);
        listGUI.setVisible(false);
        add(listGUI);

        repaint();
    }

}
