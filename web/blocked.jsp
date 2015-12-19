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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


        <style>

            body {
                background-image: url("images/block.jpg");
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
            nav navbar-nav navbar-right ul li a{
                font-family: majalla;
                font-size: 22px;
            }
        </style>
        <%@include file="ForAll.jsp" %>
    </head>
    <body>

        <div class="container">
            <div class="col-xs-12" style="margin-top: 90px;"><br>
                <a href="" style=" float: right;padding-right: 100px;color: black;font-family: Demo_ConeriaScript; font-size: 50px;" >Your account has been temporarily blocked</a>
            </div>
            <div class="col-xs-7" style="margin-left:0px; margin-top: 40px; padding-left: 0px;">
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="rows">
                                <label style="font-family: Pink_Ladies;color: black;float:right;padding-top:5px;  font-size:28px; ">
                                    <p>Suspicious activity has been detected on your account and it has been temporarily suspended as a security precaution.
                                        It is likely that your account was compromised as a result of entering wrong password three time in a row.
                                        For further enquiry, send a mail to the Admin through our website.</p></label><br>
                            </div><br>
                            <a href="home.jsp"><img src="images/Logo.jpg" width="157px" height="45px"/></a>                   
                        </div>
                    </div>
                </form>
            </div>

        </div>


    </body>
</html>
