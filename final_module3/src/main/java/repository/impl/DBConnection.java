package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";
    private static final String HOST = "localhost";
    private static final String DATABASE = "final_module3";
    private static final String PORT = "3306";

    private static Connection connection;

    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //nap driver
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?allowPublicKeyRetrieval=true&useSSL=false", USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
