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
public class Messages {

    private String Email, messageID, message, DOM;

    public Messages() {
    }

    public Messages(String Email, String messageID, String message, String DOM) {
        this.Email = Email;
        this.messageID = messageID;
        this.message = message;
        this.DOM = DOM;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public ResultSet getAll() throws SQLException {

        Connection conn = DBHelper.conn;
        String query = "select Email, messageID, message,DOM from messages";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public boolean AddMessages() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "INSERT INTO messages (Email, message) VALUES (?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Email);
        ps.setString(2, message);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {
            return true;
        }
        return false;
    }
    
     public boolean DeleteMessages() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "DELETE FROM messages WHERE messageID=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, messageID);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {
            return true;
        }
        return false;
    }
}
