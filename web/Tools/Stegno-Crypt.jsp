
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
                background-image: url("../images/Stegno-Crypt/S-C.jpg");
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
        </style>
    </head>
    <body>
        <%@include file="WorksNav.jsp" %>
        <div class="container">
            <div class="rows" style="background-color: black; width: 100%;">
                <div class="col-xs-12" style="margin-top: 90px;min-height: 100px; "><br>
                    <a href="" style=" margin-left: 250px; color: white;font-family: Demo_ConeriaScript; font-size: 70px;" > Stegno - Crypt</a></div>
            </div>
            <div class="col-xs-7" style="float: left;color: white;padding-top: 30px; font-family: Pink_Ladies; font-size: 30px;">
                <p>You can Hide your message or any text document after encryption in an image using various Steganographic technique.
                    We can encode a message into an image such that the change in colour values is negligable to the human eye.
                    This method of encoding data in an image is one of the oldest and most prolific techniques amongst image steganography.
                </p>
                <p>Along with this method, their is another method is applied security to our data i.e.Cryptography.
                    It is an ancient practice, dating back thousands of years. Substitution and shift ciphers are amongst the earliest examples of
                    cryptographic algorithms. The introduction of computers to the domain of cryptography
                    has made it even easier to break already weak substitution, shift and rotation ciphers.
                    Modern day cryptography using computers has seen the birth of numerous encryption
                    algorithms of varying strengths. </p>
            </div>
            <div class="col-xs-5" style="color: white; margin-top:40px; font-family: Needlework; font-size: 70px;">
                <a href="imagesteg.jsp"><img style="margin-left: 50px; width: 500px; height: 527px" src="../images/Stegno-Crypt/blueman.png" /></a>
            </div>
        </div>     
    </body>
</html>
