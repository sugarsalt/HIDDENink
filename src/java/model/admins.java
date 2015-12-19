/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hi
 */
public class admins {
    
    String username,password,confirmPassword;

    public admins() {
    }

    public admins(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public boolean AdminVerify() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "select username,password from admin";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (this.getUsername().equals(rs.getString("username")) && this.getPassword().equals(rs.getString("password"))) {
            return true;
            }
        }
        return false;
    }

    public boolean EditPasswordAdmin() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "update admin set password=? where username=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, confirmPassword);
        ps.setString(2, username);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {

            return true;
        }
        return false;
    }
    
}
