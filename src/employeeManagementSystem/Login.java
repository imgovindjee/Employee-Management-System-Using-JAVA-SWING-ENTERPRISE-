package employeeManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    JTextField username_jtextfeild, password_jtextfeild;

    public Login(){
//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        making the custom layOut
//        adding the USERNAME AND PASSWORD
        JLabel username_jlabel = new JLabel("Username");
        username_jlabel.setBounds(40, 20, 100, 30);
        add(username_jlabel);

        username_jtextfeild = new JTextField();
        username_jtextfeild.setBounds(150, 20, 150, 30);
        add(username_jtextfeild);

        JLabel password_jlabel = new JLabel("Password");
        password_jlabel.setBounds(40, 70, 100, 30);
        add(password_jlabel);

        password_jtextfeild = new JTextField();
        password_jtextfeild.setBounds(150, 70, 150, 30);
        add(password_jtextfeild);

//        adding Button
//        for CONTINUE
        JButton jButton = new JButton("LOGIN");
        jButton.setBounds(150, 140, 150, 30);
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        jButton.addActionListener(this); // adding ac event listener
        add(jButton);

//        adding images
        ImageIcon imageIcon_def = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image image_scale = imageIcon_def.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon((image_scale));

        JLabel image_jLabel = new JLabel(imageIcon);
        image_jLabel.setBounds(350, 0, 200, 200);
        add(image_jLabel);

//        setting the frame position and dimension
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = username_jtextfeild.getText();
            String password = password_jtextfeild.getText();

//            DB PASSWORD MATCH
            DBConnection dbConnection = new DBConnection();

            String query = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
            if(resultSet.next()){
                setVisible(false);

//                NAVIGATE to:- Home Page when all the update is Completed
//                RETURN TO DEFAULT PAGE
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                setVisible(false);
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }


//   Drive Main
    public static void main(String[] args){
        new Login();
    }
}
