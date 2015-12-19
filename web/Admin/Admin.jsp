<%-- 
    Document   : newjsp
    Created on : 13 Nov, 2015, 10:10:10 PM
    Author     : hi
--%>

<%@page import="model.Mails"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../Title.jsp" %>
        <link href="http://fonts.googleapis.com/css?family=PT+Sans:400,700" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="../css/reset.css"> <!-- CSS reset -->
        <link rel="stylesheet" href="../css/style.css"> <!-- Gem style -->
        <script src="../js/modernizr.js"></script> <!-- Modernizr -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" 
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script>
            function truncateMails()
            {
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        alert(xmlhttp.responseText);
                        document.getElementById("tableMails").innerHTML = "";
                    }
                }
                xmlhttp.open("GET", "truncateMails.jsp", true);
                xmlhttp.send();
            }
            function DeleteMail(MailID)
            {
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        alert("Mail Deleted");
                        document.getElementById("tableMails").innerHTML = xmlhttp.responseText;
                    }
                }

                xmlhttp.open("GET", "DeleteMail.jsp?mailID=" + MailID, true);
                xmlhttp.send();
            }
        </script>
        <script>
            $(document).ready(function() {
                $("input").focus(function() {
                    $(this).css("background-color", "#DEDEDE");
                });
                $("input").blur(function() {
                    $(this).css("background-color", "#ffffff");
                });
            });
        </script>

        <style>

            body {
                background-color: black;
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
        </style>
        <%@include file="ForAll3.jsp" %>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""><img src="../images/Logo.jpg" width="157px" height="45px"/></a>
                    <a class="navbar-brand" style="color: white; margin-top: 20px; margin-right: 100px;">go unseen....</a>
                </div>
                <ul class="nav navbar-nav" style="padding-left: 80px;font-family: majalla;font-size: 22px;">
                    <li class="active"><a href="Admin.jsp"><br>Admin</a></li>
                    <li class="dropdown"><a href="UserInformation.jsp"><br>User Information</a></li>
                    <li class="dropdown"><a href="UserAction.jsp"><br>User Actions</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" style="padding-top:20px;">
                    <li><a href="#" data-toggle="modal" data-target="#AdminChangePasswordModal"><span class="glyphicon glyphicon-star"></span>ADMIN</a></li>
                    <li><a href="../Logout.jsp"><span class="glyphicon glyphicon-log-out"></span> LOG OUT</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="clear"></div>

            <div class="col-xs-12" >

                <table class = "table" style="width: 100%;" id="FullTable">
                    <caption style="color: white;font-size: 40px;padding-top: 100px;padding-bottom: 50px;">Mail To Admin</caption>

                    <thead>
                        <tr style="font-size: 17px;color: black;background-color: white;">
                            <th>Mail ID</th>
                            <th>Email ID</th>
                            <th>Mail Content</th>
                            <th>Date of Action</th>
                            <th><a href="#" data-toggle="modal" onclick="truncateMails();"><span class="glyphicon glyphicon-trash"></span>Delete All Mails</a></th>
                        </tr>
                    </thead>

                    <tbody id="tableMails">
                        <%
                            String Colour[] = {"#F9C0D1", "#FEF0B3", "#F0F0F0","#CAEFEA","#F2C7F2","#E3F2E1"};
                            Mails obj = new Mails();
                            ResultSet rs;
                            rs = obj.getAll();
                            int i = 0;
                            int count = 0;
                            while (rs.next()) {
                                count++;
                        %>

                        <tr style="color: black;background-color: <%=Colour[i]%>">
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

                </table>
            </div>


            <%@include file="change.jsp" %>
            
            <%
                String mess = (String) session.getAttribute("msg");
                if (mess != null) {
            %>
            <script>
            alert("<%=mess%>");
            </script>
            <%
                    mess = null;
                    session.setAttribute("msg", mess);
                }

            %>
    </body>
</html>
