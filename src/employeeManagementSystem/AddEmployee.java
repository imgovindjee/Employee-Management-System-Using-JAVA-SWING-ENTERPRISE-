package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser; // IMPORT CUSTOM JAR FILES


public class AddEmployee extends JFrame implements ActionListener {

    Random random = new Random();
    int number = random.nextInt(999999);

    JButton add_details_jbutton, back_jbutton;
    JDateChooser dob_jDateChooser;
    JComboBox education_jComboBox;
    JLabel employeeID_jlabel_;
    JTextField name_jtextFeild, motherName_jtextFeild,
            fatherName_jtextFeild, designation_jtextFeild,
            salary_jtextFeild, address_jtextFeild, aadhaarNumber_jtextFeild,
            email_jtextFeild, phone_jtextFeild;

    public  AddEmployee(){
//        setting the frame COLOR background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        adding headings
        JLabel jLabel = new JLabel("Add Employee Details");
        jLabel.setBounds(320, 30, 500, 50);
        jLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(jLabel);

//        FROM DATA FOR EMPLOYEE DATA INPUT
//            1. name of Employee
        JLabel name_jlabel = new JLabel("Name");
        name_jlabel.setBounds(50, 150, 150, 30);
        name_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(name_jlabel);

        name_jtextFeild = new JTextField();
        name_jtextFeild.setBounds(200, 150, 150, 30);
        add(name_jtextFeild);

//        2. name of Employee Mother's
        JLabel mothersName_jlabel = new JLabel("Mother's Name");
        mothersName_jlabel.setBounds(400, 150, 150, 30);
        mothersName_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(mothersName_jlabel);

        motherName_jtextFeild = new JTextField();
        motherName_jtextFeild.setBounds(600, 150, 150, 30);
        add(motherName_jtextFeild);

//        3. DOB of Employee
        JLabel dob_jlabel = new JLabel("Date of Birth");
        dob_jlabel.setBounds(50, 200, 150, 30);
        dob_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob_jlabel);

        dob_jDateChooser = new JDateChooser(); // DATE CHOOSER FROM THE EXTERNAL FILE
        dob_jDateChooser.setBounds(200, 200, 150, 30);
        add(dob_jDateChooser);

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

        String[] Course = {"", "BBA", "BCA", "BA", "B.Com", "B.Sc", "BTech", "M.Tech", "MBA", "MA", "MCA", "M.Sc", "PhD"};
        education_jComboBox = new JComboBox(Course);
        education_jComboBox.setBackground(Color.WHITE);
        education_jComboBox.setBounds(600, 300, 150, 30);
        add(education_jComboBox);

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

        fatherName_jtextFeild = new JTextField();
        fatherName_jtextFeild.setBounds(600, 350, 150, 30);
        add(fatherName_jtextFeild);

//        10. Aadhaar Number of Employee
        JLabel aadhaarNumber_jlabel = new JLabel("Aadhaar Number");
        aadhaarNumber_jlabel.setBounds(50, 400, 150, 30);
        aadhaarNumber_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(aadhaarNumber_jlabel);

        aadhaarNumber_jtextFeild = new JTextField();
        aadhaarNumber_jtextFeild.setBounds(200, 400, 150, 30);
        add(aadhaarNumber_jtextFeild);

//        11. EmployeeID
        JLabel employeeID_jlabel = new JLabel("EmployeeID");
        employeeID_jlabel.setBounds(400, 400, 150, 30);
        employeeID_jlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(employeeID_jlabel);

        employeeID_jlabel_ = new JLabel("" + number);
        employeeID_jlabel_.setBounds(600, 400, 150, 30);
        employeeID_jlabel_.setFont(new Font("serif", Font.PLAIN, 18));
        add(employeeID_jlabel_);


//        Adding the Buttons
//        1. add Employee Details
        add_details_jbutton = new JButton("Add Details");
        add_details_jbutton.setBounds(250, 550, 150, 40);
        add_details_jbutton.setBackground(Color.BLACK);
        add_details_jbutton.setForeground(Color.WHITE);
        add_details_jbutton.addActionListener(this);
        add(add_details_jbutton);

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
        if (e.getSource() == add_details_jbutton){
            String name = name_jtextFeild.getText();
            String motherName = motherName_jtextFeild.getText();
            String dob = ((JTextField) dob_jDateChooser.getDateEditor().getUiComponent()).getText();
            String salary = salary_jtextFeild.getText();
            String address = address_jtextFeild.getText();
            String phone = phone_jtextFeild.getText();
            String email = email_jtextFeild.getText();
            String education = (String) education_jComboBox.getSelectedItem();
            String designation = designation_jtextFeild.getText();
            String fatherName = fatherName_jtextFeild.getText();
            String aadhaar = aadhaarNumber_jtextFeild.getText();
            String employeeID = employeeID_jlabel_.getText();

            try{
//                DB CONNECTION
                DBConnection dbConnection = new DBConnection();
//                SQL-QUERY
//                query to run over
                String query = "INSERT INTO employee_details VALUES('"+name+"', '"+motherName+"','"+dob+"','"+salary+"','"+address+"','"+phone+"', '"+email+"', '"+designation+"', '"+education+"', '"+fatherName+"', '"+aadhaar+"', '"+employeeID+"')";
                dbConnection.statement.executeUpdate(query); // adding the data to the SQL-DB

//                SHOWING POP-UP
                JOptionPane.showMessageDialog(null, "Employee Details added Successfully");
                setVisible(false);

//                NAVIGATE to:- Home Page when all the update is Completed
//                RETURN TO DEFAULT PAGE
                new Home();
            } catch (Exception exception){
                exception.printStackTrace();
            }
        } else if (e.getSource() == back_jbutton) {
            setVisible(false);

//            Navigate to :-
            new Home();
        }
    }


    //    Drive Code
    public static void main(String[] args){
        new AddEmployee();
    }
}
