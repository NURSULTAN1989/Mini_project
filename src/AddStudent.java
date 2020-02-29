import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddStudent extends Container{
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;


    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;

    private JButton buttonADD;
    private JButton buttonBACK;
    public AddStudent(){
        setSize(500,400);
        setLayout(null);

        nameLabel = new JLabel("NAME: ");
        nameLabel.setBounds(90, 60, 60, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60 , 150, 30);
        add(nameField);

        surnameLabel = new JLabel("SURNAME: ");
        surnameLabel.setBounds(90, 100, 60, 30);
        add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setBounds(150, 100 , 150, 30);
        add(surnameField);

        ageLabel = new JLabel("AGE: ");
        ageLabel.setBounds(90, 140, 60, 30);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 140, 150, 30);
        add(ageField);


        buttonADD = new JButton("ADD CONTACT");
        buttonADD.setBounds(90, 180, 210, 30);
        buttonADD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                String name = nameField.getText();
                String surname = surnameField.getText();
                String sAge = ageField.getText();
                int age = Integer.parseInt(sAge);
                Student st = new Student(null,name, surname, age);

///////////////////////////////////////

                PackageData addPD = new PackageData("ADD", st);
                Client.connect(addPD);



                //////////////////////////////////////////////////////////
                nameField.setText("");
                surnameField.setText("");
                ageField.setText("");
                repaint();
            }

        });
        add(buttonADD);

        buttonBACK = new JButton("BACK");
        buttonBACK.setBounds(90, 220, 210, 30);
        buttonBACK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                Client.frame.addGUI.setVisible(false);
                Client.frame.menu.setVisible(true);
                Client.frame.repaint();
            }

        });
        add(buttonBACK);
    }
}