<%-- 
    Document   : Logout
    Created on : 9 Nov, 2015, 10:39:35 AM
    Author     : hi
--%>

<%
    session = request.getSession();
    session.invalidate();
%>

<script>
    alert("Logout Successful");
</script>

<%
    response.sendRedirect("home.jsp?msg=Logout successful");
%>
