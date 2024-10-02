package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class RemoveEmployee extends JFrame implements ActionListener {

    Choice employeeId_choice;
    JButton delete_jbutton, back_jbutton;

    public RemoveEmployee () {
//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Drop Down for employeeID
        JLabel employeeId_jlabel = new JLabel("EmployeeID");
        employeeId_jlabel.setBounds(50, 50, 100, 30);
        add(employeeId_jlabel);

        employeeId_choice = new Choice();
        employeeId_choice.setBounds(200, 50, 100, 30);
        add(employeeId_choice);
//        Data insertion to the DROP-DOWN
        try{
            DBConnection dbConnection = new DBConnection();
//            SQL QUERY
//            for data fetching
            String query = "SELECT * FROM employee_details";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
            while (resultSet.next()) {
                employeeId_choice.add(resultSet.getString("employeeID"));
            }
        } catch (Exception exception) { exception.printStackTrace(); }


//         User Details to be Deleted
//        1. name of Employee
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(50, 100, 100, 30);
        add(name_jlabel);

        JLabel name_jlabel_ = new JLabel();
        name_jlabel_.setBounds(200, 100, 100, 30);
        add(name_jlabel_);

//        2.Phone of Employee
        JLabel phone_jlabel = new JLabel("Phone");
        phone_jlabel.setBounds(50, 150, 100, 30);
        add(phone_jlabel);

        JLabel phone_jlabel_ = new JLabel();
        phone_jlabel_.setBounds(200, 150, 100, 30);
        add(phone_jlabel_);

//        3.E-mail of Employee
        JLabel email_jlabel = new JLabel("Email");
        email_jlabel.setBounds(50, 200, 100, 30);
        add(email_jlabel);

        JLabel email_jlabel_ = new JLabel();
        email_jlabel_.setBounds(200, 200, 100, 30);
        add(email_jlabel_);

//        DATA insertion with respect to DROP-DOWN
        try{
            String employeeID = employeeId_choice.getSelectedItem();

            DBConnection dbConnection = new DBConnection();
//            SQL QUERY
//            for data fetching
            String query = "SELECT * FROM employee_details WHERE employeeID = '"+employeeID+"'";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
            while (resultSet.next()) {
                name_jlabel_.setText(resultSet.getString("name"));
                email_jlabel_.setText(resultSet.getString("email"));
                phone_jlabel_.setText(resultSet.getString("phone"));
            }
        } catch (Exception exception) { exception.printStackTrace(); }

//        changing the field data when ever toggled on the EMPLOYEE-ID
        employeeId_choice.addItemListener ( new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e) {
                try{
                    String employeeID = employeeId_choice.getSelectedItem();

                    DBConnection dbConnection = new DBConnection();
//                     SQL QUERY
//                     for data fetching
                    String query = "SELECT * FROM employee_details WHERE employeeID = '"+employeeID+"'";
                    ResultSet resultSet = dbConnection.statement.executeQuery(query);
                    while (resultSet.next()) {
                        name_jlabel_.setText(resultSet.getString("name"));
                        email_jlabel_.setText(resultSet.getString("email"));
                        phone_jlabel_.setText(resultSet.getString("phone"));
                    }
                } catch (Exception exception) { exception.printStackTrace(); }
            }
        });

//        Creation of the different buttons
//        1. Delete Button
        delete_jbutton = new JButton("Delete");
        delete_jbutton.setBounds(80, 300, 100, 30);
        delete_jbutton.setBackground(Color.BLACK);
        delete_jbutton.setForeground(Color.WHITE);
        delete_jbutton.addActionListener(this);
        add(delete_jbutton);

//        2. Back Button
        back_jbutton = new JButton("Back");
        back_jbutton.setBounds(220, 300, 100, 30);
        back_jbutton.setBackground(Color.BLACK);
        back_jbutton.setForeground(Color.WHITE);
        back_jbutton.addActionListener(this);
        add(back_jbutton);

//        adding images
        ImageIcon imageIcon_def = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image image_scale = imageIcon_def.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon((image_scale));

        JLabel image_jLabel = new JLabel(imageIcon);
        image_jLabel.setBounds(350, 0, 600, 400);
        add(image_jLabel);


//        setting the frame position and dimension
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete_jbutton) {
            try{
                String employeeID = employeeId_choice.getSelectedItem();

                DBConnection dbConnection = new DBConnection();
//                     SQL QUERY
//                     for data fetching
                String query = "DELETE FROM employee_details WHERE employeeID = '"+employeeID+"'";
                dbConnection.statement.executeUpdate(query);

//                showing the success pop-up
                JOptionPane.showMessageDialog(null, "Employee Information with ID:- "+employeeID+" Deleted Successfully");
                setVisible(false);

//                NAVIGATE to:- Home Page when all the update is Completed
//                RETURN TO DEFAULT PAGE
                new Home();
            } catch (Exception exception) { exception.printStackTrace(); }
        } else {
            setVisible(false);

//            NAVIGATE to:- Home Page when all the update is Completed
//            RETURN TO DEFAULT PAGE
            new Home();
        }
    }


//    DRIVE Main
    public static void main (String[] args) {
        new RemoveEmployee();
    }
}
