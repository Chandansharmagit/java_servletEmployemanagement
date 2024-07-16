import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class databaseconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "C@nt3rbur";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish and return the connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//        String sql = "ALTER TABLE users " + "ADD COLUMN phone VARCHAR(20), " + "ADD COLUMN address VARCHAR(255), " + "ADD COLUMN department VARCHAR(255), " + "ADD COLUMN jobTitle VARCHAR(255);";
//
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.executeUpdate();
//        System.out.println("Data updated successfully");

//        statement.close(); // Close the statement
//
//        System.out.println("Connected to the database!");
        return connection;
    }

//    public static void main(String[] args) {
//        try {
//            getConnection();
//        } catch (SQLException | ClassNotFoundException e) {
//            System.err.println("Error: " + e.getMessage());
//        }
//    }
}