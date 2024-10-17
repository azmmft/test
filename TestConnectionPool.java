import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnectionTest {
    public static void main(String[] args) {
        // Replace with your actual connection string, username, and password
        String url = "jdbc:sqlserver://localhost:1433;databaseName=yourDatabase"; // Example for SQL Server
        String user = "yourUsername";
        String password = "yourPassword";

        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connection successful!");
                connection.close(); // Close the connection
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace(); // Print the error details
        }
    }
}
