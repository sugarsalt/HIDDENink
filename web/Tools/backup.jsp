
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <%@include file="../Title.jsp" %>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../jumbotron.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
        <style>

            body {
                background-image: url("../images/backup/db1.jpg");
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
            .btn-danger {
                color: black;
                background-color: white;
                border-color:white;
            }

            .btn-info {
                color: #fff;
                background-color: maroon;
                border-color: white;
            }
            .btn-info:hover{
                background-color: #CF140B;
            }
        </style>
    </head>
    <body>
        <%@include file="WorksNav.jsp" %>
        <div class="container">
            <div class="rows" style="background-color: white; width: 100%;">
                <div class="col-xs-12" style="margin-top: 90px; background-color: none; min-height: 100px; ">
                    <br>
                    <a href="" style=" margin-left: 250px; color: white;font-family: Demo_ConeriaScript; font-size: 70px;" >Backup Utility</a>
                </div>
            </div><br> 
            <div class="col-xs-10" style="margin-left:0px; margin-top: 40px; padding-left: 50px;">
                <form class="navbar-form navbar-right" >
                    <div class="form-group" style="color: white;font-family: Pink_Ladies; font-size: 35px;">
                        Backup Application are computer programs used to perform backup, they create supplementary exact copies of files, databases or entire computers. 
                        These programs may later use the supplementary copies to restore the original contents in the event of data loss.
                    </div><br><br>
                    <a href="../Applications\UtilityBackUp_JAR_FILE.rar" class="btn btn-info" role="download" style="color: white;"><span class="glyphicon glyphicon-download"></span>Download</a>    
                </form>
            </div>
        </div>
    </body>
</html>