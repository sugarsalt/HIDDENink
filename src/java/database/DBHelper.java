/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hi
 */
public class DBHelper {
     public static String username = "root";
    public static String password = "";
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost/hiddeninkdatabase";
    public static Connection conn = null;

    static {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
