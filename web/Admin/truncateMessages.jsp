<%-- 
    Document   : truncateUsers
    Created on : 24 Nov, 2015, 11:15:39 AM
    Author     : hi
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%
    String query = "Truncate messages";
    Connection conn = DBHelper.conn;
    PreparedStatement ps = conn.prepareStatement(query);
    int rowsAff = ps.executeUpdate();
    out.println("All Messages deleted");
%>