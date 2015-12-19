<%-- 
    Document   : truncateMails
    Created on : 24 Nov, 2015, 12:19:27 PM
    Author     : hi
--%>


<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%
    String query = "Truncate mailtoadmin";
    Connection conn = DBHelper.conn;
    PreparedStatement ps = conn.prepareStatement(query);
    int rowsAff = ps.executeUpdate();
    out.println("All Mails deleted");
%>