/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import database.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author netmax
 */
/* javaBean class */
public class Users implements Serializable {

    private String Fname, Lname, Email, password, ConfirmPassword,status;

    public Users() {
    }

    public Users(String Fname, String Lname, String Email, String password, String ConfirmPassword, String status) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.password = password;
        this.ConfirmPassword = ConfirmPassword;
        this.status = status;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean loginVerify() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "select First_Name,Last_Name,Email,password from user";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (this.getEmail().equals(rs.getString("Email")) && this.getPassword().equals(rs.getString("password"))) {
                String Fn = rs.getString("First_Name");
                this.setFname(Fn);
                String Ln = rs.getString("Last_Name");
                this.setLname(Ln);
                return true;
            }
        }
        return false;
    }

    public boolean SignupConfirm() throws SQLException {
        boolean success = false;
        Connection conn = DBHelper.conn;
        String query = "insert into user(First_Name,Last_Name,Email,password) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Fname);
        ps.setString(2, Lname);
        ps.setString(3, Email);
        ps.setString(4, password);
        int rowsAff = ps.executeUpdate();
        if (rowsAff > 0) {
            return true;
        }
        return success;
    }

    public boolean CheckStatus() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "select status from user where Email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("status").equals("Block")) {
                return false;
            }
        }
        return true;
    }

    public boolean UpdateStatus() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "update user set status=? where Email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "Block");
        ps.setString(2, Email);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {

            return true;
        }
        return false;
    }

    public boolean EditPassword() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "update user set password=? where Email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ConfirmPassword);
        ps.setString(2, Email);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {

            return true;
        }
        return false;
    }

    public ResultSet getAll() throws SQLException {

        Connection conn = DBHelper.conn;
        String query = "select First_Name,Last_Name,Email,password,status from user";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public boolean UpdateData() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "update user set password=?, First_Name=?, Last_Name=?, status=?  where Email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, password);
        ps.setString(2, Fname);
        ps.setString(3, Lname);
        ps.setString(4, status);
        ps.setString(5, Email);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {

            return true;
        }
        return false;
    }
}
