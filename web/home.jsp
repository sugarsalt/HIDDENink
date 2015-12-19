<%-- 
    Document   : newjsp
    Created on : 13 Nov, 2015, 10:10:10 PM
    Author     : hi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Title.jsp" %>
        <link href="http://fonts.googleapis.com/css?family=PT+Sans:400,700" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
        <link rel="stylesheet" href="css/style.css"> <!-- Gem style -->
        <script src="js/modernizr.js"></script> <!-- Modernizr -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" 
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
        <%@include file="ForAll.jsp" %>
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
                    <a class="navbar-brand" href=""><img src="images/Logo.jpg" width="157px" height="45px"/></a>
                    <a class="navbar-brand" style="color: white; margin-top: 20px; margin-right: 100px;">go unseen....</a>
                </div>
                <%
                    session = request.getSession();
                    String First_Name = (String) session.getAttribute("First_Name");
                    if (First_Name == null) {
                %>
                <ul class="nav navbar-nav" style="padding-left: 80px;font-family: majalla;font-size: 22px;">
                    <li class="active"><a href="home.jsp"><br>HOME</a></li>
                    <li class="dropdown"><a href="work.jsp"><br>WORK</a></li>
                    <li class="dropdown"><a href="Contactus.jsp"><br>CONTACT US</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" style="padding-top:20px;">
                    <li><a href="#" data-toggle="modal" data-target="#SignupModal"><span class="glyphicon glyphicon-user"></span> SIGN UP</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#LoginModal"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#AdminModal"><span class="glyphicon glyphicon-star"></span></a></li>

                    <%                                    } else {
                        First_Name = First_Name.toUpperCase();

                    %>
                    <ul class="nav navbar-nav" style="padding-left: 80px;font-family: majalla;font-size: 22px;">
                        <li class="active"><a href="home.jsp"><br>HOME</a></li>
                        <li class="dropdown"><a href="work.jsp"><br>WORK</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><br>TOOLS<span class="caret"></span></a>
                            <ul class="dropdown-menu" style="padding-top: 0px;">
                                <li><a href="Tools/Video_Audio.jsp">Video and Audio Steganography</a></li>
                                <li><a href="Tools/Stegno-Crypt.jsp">Stegno-Crypt</a></li>
                                <li><a href="Tools/backup.jsp">Backup Utility</a></li>
                                <li><a href="Tools/screenrec.jsp">Screen Recorder</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="Contactus.jsp"><br>CONTACT US</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="padding-top:20px;">

                        <li><a href="#" data-toggle="modal" data-target="#AccountModal"><span class="glyphicon glyphicon-user"></span> <%=First_Name%> </a></li>
                        <li><a href="Logout.jsp"><span class="glyphicon glyphicon-log-out"></span> LOG OUT</a></li>
                            <%    }
                            %>
                    </ul>
            </div>
        </nav>
        <%@include file="LoginPopUp.jsp" %>
        <div class="container">
            <div class="col-xs-12" style="padding: 0px;margin: 0px;"><br>
                <%@include file="Slider2.jsp" %>
            </div>
        </div>


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
