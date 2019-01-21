package swm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Database {
    private static String url = "jdbc:sqlite:C:/Users/cdot/Desktop/newdb.db";    
    private static String driverName = "org.sqlite.JDBC";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
          
                try {
					con = DriverManager.getConnection("jdbc:sqlite:C://Users//cdot//Desktop//newdb.db");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("Success!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found."); 
        }
        return con;
    }
}