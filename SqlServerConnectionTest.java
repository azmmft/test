/**
* Testing the connectivity using java and jdbc and keepalive property. 
* The url argument must specify an absolute as you get the connection string <a href="#{@link}">{@link URL}</a>.
* It is not importing the Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
* Ypu need to compile passing directly the driver locally directly from compile java command [look](https://github.com/azmmft/test/tree/main?tab=readme-ov-file#test)
* <p>
* This method always returns immediately, the connction succeed or not 
* image exists. When it succeed it keepsend the keepalive
*
* @param  url  an absolute URL giving the base location of the image
* @return      connectivity status
* @see         echo"Connection is still open"
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class SqlServerConnectionTest {
    public static void main(String[] args) {
        String connectionString = "jdbc:sqlserver://example.database.windows.net:1433;database=DB1;user=sabrin;password=;encrypt=true;trustServerCertificate=false;loginTimeout=30;";
 
        Properties properties = new Properties();
        properties.setProperty("user", "example");
        properties.setProperty("password", "");
        properties.setProperty("encrypt", "true");
        properties.setProperty("trustServerCertificate", "false");
        properties.setProperty("loginTimeout", "30");
        properties.setProperty("socketKeepAlive", "false"); // Disable TCP keep-alive
 
        try (Connection connection = DriverManager.getConnection(connectionString, properties)) {
            System.out.println("Connection to Azure SQL Database established.");
 
            // Keep the connection open
            while (true) {
                if (!connection.isClosed()) {
                    System.out.println("Connection is still open.");
                }
 
                // Wait for 10 seconds before checking again
                Thread.sleep(10000);
            }
        } catch (SQLException | InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
