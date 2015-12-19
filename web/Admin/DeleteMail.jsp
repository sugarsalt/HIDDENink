<%-- 
    Document   : DeleteMail
    Created on : 24 Nov, 2015, 12:18:08 PM
    Author     : hi
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.Mails"%>
<%
    String MailID = (String) request.getParameter("mailID");
    Mails obj = new Mails();
    obj.setMailID(MailID);
    if (obj.DeleteMails()) {
        System.out.println("Mail Deleted");
    } else {
        System.out.println("Unable to Deleted Mail");
    }
%>

<tbody id="tableMails">
    <%
        String look[] = {"warning", "success", "active", "danger", "info", "primary"};
        Mails obj1 = new Mails();
        ResultSet rs;
        rs = obj1.getAll();
        int i = 0;
        int count = 0;
        while (rs.next()) {
            count++;
    %>

    <tr class = "<%=look[i]%>" style="color: black;">
        <td id="MailID<%=count%>"><%=rs.getString("MailID")%></td>
        <td id="email<%=count%>"><%=rs.getString("Email")%></td>
        <td id="Content<%=count%>"><%=rs.getString("Content")%></td>
        <td id="DOM<%=count%>"><%=rs.getString("DOM")%></td>
        <td><a href="#" data-toggle="modal" onclick="DeleteMail(<%=rs.getString("MailID")%>);"><span class="glyphicon glyphicon-trash"></span>Delete</a></td>

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
