package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {

    JButton add_employee_jbutton, view_employee_jbutton;
    JButton update_employee_jbutton, remove_employee_jbutton;

    public Home(){
//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        adding images
        ImageIcon imageIcon_def = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image image_scale = imageIcon_def.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon((image_scale));

        JLabel image_jLabel = new JLabel(imageIcon);
        image_jLabel.setBounds(0, 0, 1120, 630);
        add(image_jLabel);

//        adding headings
        JLabel jLabel = new JLabel("Employee Management System");
        jLabel.setBounds(620, 20, 400, 40);
        jLabel.setFont(new Font("Raleway", Font.BOLD, 25));
        image_jLabel.add(jLabel);

//        Adding the Buttons for E-DBMS Management
//        1.add Employee
        add_employee_jbutton = new JButton("Add Employee");
        add_employee_jbutton.setBounds(650, 80, 150, 40);
        add_employee_jbutton.addActionListener(this);
        image_jLabel.add(add_employee_jbutton);
//        2.View Employee
        view_employee_jbutton = new JButton("View Employee's");
        view_employee_jbutton.setBounds(820, 80, 150, 40);
        view_employee_jbutton.addActionListener(this);
        image_jLabel.add(view_employee_jbutton);
//        3.Update Employee
        update_employee_jbutton = new JButton("Update Employee");
        update_employee_jbutton.setBounds(650, 140, 150, 40);
        update_employee_jbutton.addActionListener(this);
        image_jLabel.add(update_employee_jbutton);
//        4.Remove Employee
        remove_employee_jbutton = new JButton("Remove Employee");
        remove_employee_jbutton.setBounds(820, 140, 150, 40);
        remove_employee_jbutton.addActionListener(this);
        image_jLabel.add(remove_employee_jbutton);

//        setting the frame position and dimension
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_employee_jbutton){
            setVisible(false);
            new AddEmployee();
        } else if(e.getSource() == view_employee_jbutton){
            setVisible(false);
            new ViewEmployees();
        } else if(e.getSource() == update_employee_jbutton){
            setVisible(false);
            new ViewEmployees();
        } else{
            setVisible(false);
            new RemoveEmployee();
        }
    }

    //    Drive Main
    public static void main(String[] args){
        new Home();
    }
}
