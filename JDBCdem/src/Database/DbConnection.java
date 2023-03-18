package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() {
        Connection conn = null;
        // 1. Load the driver
        try {
    		String url = "jdbc:mysql://localhost:3306/demoJDBC";
    		String uname = "root";
    		String pass = "root";
    		
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection(
                    url,
                    uname,pass);
            System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}


