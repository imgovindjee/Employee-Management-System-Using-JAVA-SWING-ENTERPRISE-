package employeeManagementSystem;

import net.proteanit.sql.DbUtils; // IMPORT CUSTOM JAR FILES

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ViewEmployees extends JFrame implements ActionListener {

    JTable jTable;
    Choice employeeID_choice;
    JButton search_jbutton, print_jButton, update_jButton, back_jButton;

    public ViewEmployees(){
//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        adding the Searching functionality
//        SEARCH LABEL
        JLabel search_jLabel = new JLabel("Search by EmployeeID");
        search_jLabel.setBounds(20, 20, 150, 20);
        add(search_jLabel);
//        SEARCH BOX
        employeeID_choice = new Choice();
        employeeID_choice.setBounds(180, 20, 150, 20);
        add(employeeID_choice);
        try {
            DBConnection dbConnection = new DBConnection();
//            SQL QUERY
//            Running over the DB
            String query = "SELECT * FROM employee_details";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
//            adding the employeeID
            employeeID_choice.add("");
            while (resultSet.next()) {
                employeeID_choice.add(resultSet.getString("employeeId"));
            }
        } catch (Exception e) { e.printStackTrace(); }


//        creating a table instance in JFrame
        jTable = new JTable();
        try {
//            DB Connection
            DBConnection dbConnection = new DBConnection();
//            SQL QUERY
//            Running over the DB
            String query = "SELECT * FROM employee_details";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);

//            adding the data to the table
            jTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) { e.printStackTrace(); }

//        handling the scroll overflow
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 110, 900, 600);
        add(jScrollPane);


//        adding BUTTON's
//        1. Search Button
        search_jbutton = new JButton("Search");
        search_jbutton.setBounds(20, 70, 80, 20);
        search_jbutton.addActionListener(this);
        add(search_jbutton);

//        2. print Button
        print_jButton = new JButton("Print");
        print_jButton.setBounds(120, 70, 80, 20);
        print_jButton.addActionListener(this);
        add(print_jButton);

//        3. Search Button
        update_jButton = new JButton("Update");
        update_jButton.setBounds(220, 70, 80, 20);
        update_jButton.addActionListener(this);
        add(update_jButton);

//        4. Back Button
        back_jButton = new JButton("Back");
        back_jButton.setBounds(320, 70, 80, 20);
        back_jButton.addActionListener(this);
        add(back_jButton);


//        setting the frame position and dimension
        setSize(930, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_jbutton) {
            String employeeID = employeeID_choice.getSelectedItem();

//            SQL QUERY
//            FOR SELECTION EMPLOYEE DETAILS ON THE BASIC OF
//            employeeID
            String query = "SELECT * FROM employee_details WHERE employeeID = '"+employeeID+"'";
            try {
//                DB CONNECTION
                DBConnection dbConnection = new DBConnection();
                ResultSet resultSet = dbConnection.statement.executeQuery(query);
//                adding the data to the table
                jTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception exception) { exception.printStackTrace(); }
        } else if (e.getSource() == print_jButton) {
            try {
                jTable.print();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getSource() == update_jButton) {
            String employeeID = employeeID_choice.getSelectedItem();

            setVisible(false);
//            NAVIGATE to:- Home Page when all the update is Completed
//            RETURN TO DEFAULT PAGE
            new UpdateEmployee(employeeID);
        } else {
            setVisible(false);
//            NAVIGATE to:- Home Page when all the update is Completed
//            RETURN TO DEFAULT PAGE
            new Home();
        }
    }


//    DRIVE Main
    public static void main(String[] args){
        new ViewEmployees();
    }
}
