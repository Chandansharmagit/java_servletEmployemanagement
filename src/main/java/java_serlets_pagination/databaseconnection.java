package java_serlets_pagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseconnection {
    private static String username = "root";
    private static String password = "C@nt3rbur";
    private static String url = "jdbc:mysql://localhost:3306/servlet";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(username, password, url);
        System.out.println("connection established");
        return connection;


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getConnection();
    }


}

