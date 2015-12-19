
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
                background-image: url("../images/Screen_Recorder/Sreen_Recoder_2_1.jpg");
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
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
            <div class="rows" style="background-color: black; width: 100%;">
                <div class="col-xs-12" style="margin-top: 90px;min-height: 100px; "><br>
                    <a href="" style=" margin-left: 250px; color: black;font-family: Demo_ConeriaScript; font-size: 70px;" > Screen Recording</a></div>
            </div>
            <div class="col-xs-7" style="margin-left: 0px; color: black;padding-top: 30px;font-weight: bold;font-family: Pink_Ladies; font-size: 35px;">
                <p>You can record your PC applications to demonstrate a product, create a presentation, make a tutorial, or perform a web site review. You have a choice to record the full desktop screen or single application window. The program creates high-quality,small-size video files.</p>
                <p>Save Time and Money.
                    <br>Customize look and feel and publish your video!
                    <br>Easy to learn and operate.</p>
            </div>
            <div class="col-xs-5">
            </div>
            <div class="col-xs-12" style="margin-left:0px; margin-top: 0px; padding-left: 0px;">
                <form class="navbar-form navbar-left" method="POST" enctype="multipart/form-data"  >
                    <a href="../Applications\ScreenRecorder_JAR_FILE.rar" class="btn btn-info" role="download" style="color: white"><span class="glyphicon glyphicon-download"></span>Download</a>    
                </form>
            </div>
        </div>     
    </body>
</html>
