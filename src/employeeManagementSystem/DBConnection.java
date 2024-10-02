package employeeManagementSystem;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


//    JDBC CONNECTION's
public class DBConnection {
    Connection connection;
    Statement statement;
    public DBConnection(){
        try {
//            REGISTER A SQL DB
            Class.forName("com.mysql.cj.jdbc.Driver");

//            ESTABLISHING THE CONNECTION TO THE DRIVER
            connection = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "$Govindjee123_");

//            CREATING AN STATEMENT
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
