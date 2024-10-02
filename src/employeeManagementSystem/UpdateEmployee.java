package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class UpdateEmployee extends JFrame implements ActionListener {

    JButton update_details_jbutton, back_jbutton;
    JLabel employeeID_jlabel_;
    JTextField  designation_jtextFeild, salary_jtextFeild, education_jtextfeild,
            address_jtextFeild, email_jtextFeild, phone_jtextFeild;

    String employeeID;

    public UpdateEmployee(String employeeID) {
        this.employeeID = employeeID;

//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        adding headings
        JLabel jLabel = new JLabel("Update Employee Details");
        jLabel.setBounds(320, 30, 500, 50);
        jLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(jLabel);

//        FROM DATA FOR EMPLOYEE DATA INPUT
//         1. name of Employee
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(50, 150, 150, 30);
        name_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(name_jlabel);

        JLabel name_jlabel_ = new JLabel();
        name_jlabel_.setBounds(200, 150, 150, 30);
        add(name_jlabel_);

//        2. name of Employee Mother's
        JLabel mothersName_jlabel = new JLabel("Mother's Name");
        mothersName_jlabel.setBounds(400, 150, 150, 30);
        mothersName_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(mothersName_jlabel);

        JLabel motherName_jlabel_ = new JLabel();
        motherName_jlabel_.setBounds(600, 150, 150, 30);
        add(motherName_jlabel_);

//        3. DOB of Employee
        JLabel dob_jlabel = new JLabel("Date of Birth");
        dob_jlabel.setBounds(50, 200, 150, 30);
        dob_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob_jlabel);

        JLabel dob_jlabel_ = new JLabel(); // DATE CHOOSER FROM THE EXTERNAL FILE
        dob_jlabel_.setBounds(200, 200, 150, 30);
        add(dob_jlabel_);

//        4. Salary of Employee
        JLabel salary_jlabel = new JLabel("Salary");
        salary_jlabel.setBounds(400, 200, 150, 30);
        salary_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(salary_jlabel);

        salary_jtextFeild = new JTextField();
        salary_jtextFeild.setBounds(600, 200, 150, 30);
        add(salary_jtextFeild);

//        5. address of Employee
        JLabel address_jlabel = new JLabel("Address");
        address_jlabel.setBounds(50, 250, 150, 30);
        address_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(address_jlabel);

        address_jtextFeild = new JTextField();
        address_jtextFeild.setBounds(200, 250, 150, 30);
        add(address_jtextFeild);

//        6. Phone of Employee
        JLabel phone_jlabel = new JLabel("Phone");
        phone_jlabel.setBounds(400, 250, 150, 30);
        phone_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone_jlabel);

        phone_jtextFeild = new JTextField();
        phone_jtextFeild.setBounds(600, 250, 150, 30);
        add(phone_jtextFeild);

//        7. Email of Employee
        JLabel email_jlabel = new JLabel("E-mail");
        email_jlabel.setBounds(50, 300, 150, 30);
        email_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(email_jlabel);

        email_jtextFeild = new JTextField();
        email_jtextFeild.setBounds(200, 300, 150, 30);
        add(email_jtextFeild);

//        7. Education of Employee
        JLabel education_jlabel = new JLabel("Highest Education");
        education_jlabel.setBounds(400, 300, 150, 30);
        education_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(education_jlabel);

        education_jtextfeild = new JTextField();
        education_jtextfeild.setBounds(600, 300, 150, 30);
        add(education_jtextfeild);

//        8. Designation of Employee
        JLabel designation_jlabel = new JLabel("Designation");
        designation_jlabel.setBounds(50, 350, 150, 30);
        designation_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(designation_jlabel);

        designation_jtextFeild = new JTextField();
        designation_jtextFeild.setBounds(200, 350, 150, 30);
        add(designation_jtextFeild);

//        9. Father's of Employee
        JLabel fatherName_jlabel = new JLabel("Father's Name");
        fatherName_jlabel.setBounds(400, 350, 150, 30);
        fatherName_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(fatherName_jlabel);

        JLabel fatherName_jlabel_ = new JLabel();
        fatherName_jlabel_.setBounds(600, 350, 150, 30);
        add(fatherName_jlabel_);

//        10. Aadhaar Number of Employee
        JLabel aadhaarNumber_jlabel = new JLabel("Aadhaar Number");
        aadhaarNumber_jlabel.setBounds(50, 400, 150, 30);
        aadhaarNumber_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(aadhaarNumber_jlabel);

        JLabel aadhaarNumber_jlabel_ = new JLabel();
        aadhaarNumber_jlabel_.setBounds(200, 400, 150, 30);
        add(aadhaarNumber_jlabel_);

//        11. EmployeeID
        JLabel employeeID_jlabel = new JLabel("EmployeeID");
        employeeID_jlabel.setBounds(400, 400, 150, 30);
        employeeID_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(employeeID_jlabel);

        employeeID_jlabel_ = new JLabel();
        employeeID_jlabel_.setBounds(600, 400, 150, 30);
        employeeID_jlabel_.setFont(new Font("serif", Font.PLAIN, 18));
        add(employeeID_jlabel_);


        try {
//        DB Connection
            DBConnection dbConnection = new DBConnection();
//            SQL QUERY
//            for data fetching
            String query = "SELECT * FROM employee_details WHERE employeeID = '"+employeeID+"'";
            ResultSet resultSet = dbConnection.statement.executeQuery(query);
            while (resultSet.next()) {
//                Unchangeable Fields
                name_jlabel_.setText(resultSet.getString("name"));
                fatherName_jlabel_.setText(resultSet.getString("fatherName"));
                motherName_jlabel_.setText(resultSet.getString("motherName"));
                dob_jlabel_.setText(resultSet.getString("DOB"));
                employeeID_jlabel_.setText(employeeID);
                aadhaarNumber_jlabel_.setText(resultSet.getString("aadhaar"));

//                changeable fields
                salary_jtextFeild.setText(resultSet.getString("salary"));
                address_jtextFeild.setText(resultSet.getString("Address"));
                phone_jtextFeild.setText(resultSet.getString("phone"));
                email_jtextFeild.setText(resultSet.getString("email"));
                designation_jtextFeild.setText(resultSet.getString("designation"));
                education_jtextfeild.setText(resultSet.getString("education"));
            }
        } catch (Exception exception) { exception.printStackTrace(); }


//        Adding the Buttons
//        1. add Employee Details
        update_details_jbutton = new JButton("Update Details");
        update_details_jbutton.setBounds(250, 550, 150, 40);
        update_details_jbutton.setBackground(Color.BLACK);
        update_details_jbutton.setForeground(Color.WHITE);
        update_details_jbutton.addActionListener(this);
        add(update_details_jbutton);

//        2. Back
        back_jbutton = new JButton("Back");
        back_jbutton.setBounds(450, 550, 150, 40);
        back_jbutton.setBackground(Color.BLACK);
        back_jbutton.setForeground(Color.WHITE);
        back_jbutton.addActionListener(this);
        add(back_jbutton);


//        setting the frame position and dimension
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_jbutton){
            setVisible(false);
            new Home();
        } else if (e.getSource() == update_details_jbutton) {
            String salary = salary_jtextFeild.getText();
            String address = address_jtextFeild.getText();
            String phone = phone_jtextFeild.getText();
            String email = email_jtextFeild.getText();
            String education = education_jtextfeild.getText();
            String designation = designation_jtextFeild.getText();

            try{
//                DB CONNECTION
                DBConnection dbConnection = new DBConnection();
//                SQL-QUERY
//                query to run over
                String query = "UPDATE employee_details SET salary = '"+salary+"', email = '"+email+"', phone = '"+phone+"', Address = '"+address+"', education = '"+education+"', designation = '"+designation+"' WHERE employeeID = '"+employeeID+"'";
                dbConnection.statement.executeUpdate(query); // adding the data to the SQL-DB

//                SHOWING POP-UP
                JOptionPane.showMessageDialog(null, "Employee Details Updated Successfully");
                setVisible(false);
//                NAVIGATE to:- Home Page when all the update is Completed
//                RETURN TO DEFAULT PAGE
                new Home();
            } catch (Exception exception) { exception.printStackTrace(); }
        }
    }


//    DRIVE MAIN
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
