<%-- 
    Document   : sessionVerify
    Created on : 9 Nov, 2015, 10:35:23 AM
    Author     : hi
--%>

<%
    session = request.getSession();
    String Email=request.getParameter("Email");
    String First_Name = (String) session.getAttribute("First_Name");
    if (First_Name == null) {
%>
<script>
    alert("Login First");
</script>
<%
        response.sendRedirect("home.jsp?msg=Login first");
    }
%>