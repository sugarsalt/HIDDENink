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
public class Mails {

    private String Email, MailID, Mail, DOM;

    public Mails() {
    }

    public Mails(String Email, String MailID, String Mail, String DOM) {
        this.Email = Email;
        this.MailID = MailID;
        this.Mail = Mail;
        this.DOM = DOM;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String MailID) {
        this.MailID = MailID;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public ResultSet getAll() throws SQLException {

        Connection conn = DBHelper.conn;
        String query = "select Email, MailID, Content,DOM from mailtoadmin";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public boolean AddMails() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "INSERT INTO mailtoadmin (Email, Content) VALUES (?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Email);
        ps.setString(2, Mail);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {
            return true;
        }
        return false;
    }
    
     public boolean DeleteMails() throws SQLException {
        Connection conn = DBHelper.conn;
        String query = "DELETE FROM mailtoadmin WHERE MailID=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, MailID);
        int rowsAff = ps.executeUpdate();
        while (rowsAff > 0) {
            return true;
        }
        return false;
    }
}
