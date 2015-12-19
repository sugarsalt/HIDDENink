<%-- 
    Document   : errorPage
    Created on : 14 Nov, 2015, 11:14:28 AM
    Author     : hi
--%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>HIDDENink</title>
        <link rel="icon" href="../images/miniLogoSnap.jpg" type="images/jpeg" sizes="16x16">
    </head>
    <style>
        body {
            background-image: url("../images/error.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        @font-face {
            font-family: majalla;
            src: url(../MyFonts/majalla.ttf);
        }
    </style>

    <body>
        <div style="color:maroon ;font-family: majalla;font-weight: bold;font-size: 40px;margin-top:450px;margin-left: 350px; "><%=exception%></div>
    </body>
</html>
