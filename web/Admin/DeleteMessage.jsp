<%-- 
    Document   : DeleteMessage
    Created on : 24 Nov, 2015, 11:29:20 AM
    Author     : hi
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.Messages"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.DBHelper"%>
<%@page import="java.sql.Connection"%>

<%
    String messID = (String) request.getParameter("messID");
    Messages obj = new Messages();
    obj.setMessageID(messID);
    if (obj.DeleteMessages()) {
        System.out.println("Messages Deleted");
    } else {
        System.out.println("Unable to Deleted Message");
    }
%>

<%--<table class = "table" id="table1" style="width: 100%;">
                    <caption style="color: white;font-size: 40px;padding-top: 100px;padding-bottom: 50px;">Action Performed by all Signed User</caption>

                    <thead>
                        <tr style="font-size: 17px;color: black;background-color: white;">
                            <th>Message ID</th>
                            <th>Email ID/User ID</th>
                            <th>Message Encode/Decode</th>
                            <th>Date of Action</th>
                            <th><a href="#" data-toggle="modal" onclick="truncateMessages();"><span class="glyphicon glyphicon-trash"></span>Delete All Records</a></th>
                        </tr>
                    </thead>
--%>
                    <tbody id="tableMessages1">
                        <%
                            String look[] = {"warning", "success", "active", "danger", "info", "primary"};
                            Messages obj1 = new Messages();
                            ResultSet rs;
                            rs = obj1.getAll();
                            int i = 0;
                            int count = 0;
                            while (rs.next()) {
                                count++;
                        %>

                        <tr class = "<%=look[i]%>" style="color: black;">
                            <td id="messageID<%=count%>"><%=rs.getString("messageID")%></td>
                            <td id="email<%=count%>"><%=rs.getString("Email")%></td>
                            <td id="message<%=count%>"><%=rs.getString("message")%></td>
                            <td id="DOM<%=count%>"><%=rs.getString("DOM")%></td>
                            <td><a href="#" data-toggle="modal" onclick="DeleteMessage(<%=rs.getString("messageID")%>);"><span class="glyphicon glyphicon-trash"></span>Delete</a></td>

                            <%
                                if (i < 5) {
                                    i++;
                                } else {
                                    i = 0;
                                }
                            %>
                        </tr>
                        <%                                }
                        %>
                    </tbody>

<%--                </table>
--%>