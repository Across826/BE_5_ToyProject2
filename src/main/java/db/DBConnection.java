package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance() {
        String url = "jdbc:mysql://localhost:3306/baseball";
        String userName = "root";
        String passWord = "root1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, passWord);
            System.out.println("된듯?");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
