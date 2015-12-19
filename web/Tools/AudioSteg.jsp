
<html lang="en">
    <head>
        <%@include file="../Title.jsp" %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../jumbotron.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
        <script>
            function clear() {
                document.getElementById("message").value = "#";
            }

        </script>
        
        <style>

            body {
                background-image: url("../images/Video_audio/speaker.jpg");
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
                    <a href="" style=" margin-left: 250px; color: white;font-family: Demo_ConeriaScript; font-size: 70px;" > Audio Steganography</a></div>
            </div><br> 

            <div class="col-xs-2" style="margin-left:0px; margin-top: 40px; padding-left: 50px;">
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="rows">
                                <label style=" font-family: majalla;color: white;float:right; padding-top:25px;  font-size:28px; ">*Container File</label>
                            </div><br><br>
                            <div class="rows">
                                <label style=" font-family: majalla;color: white;float:right;padding-top:5px;  padding-left: 55px; font-size:28px; ">*Message</label><br> 
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-xs-9" style="margin-left:0px; margin-top: 40px; padding-left: 50px;">
                <form class="navbar-form navbar-left"  method="POST" enctype="multipart/form-data"  >
                    <div class="form-group">
                        <div class="form-group">
                            <div class="rows">
                                <input class="btn btn-danger" style="color: #CF140B;font-weight: bold;  margin-top:25px;width: 222px;" type="file" name="f1" id="fileUpload1" accept=".au,.wav" required="required"/>
                            </div><br>
                            <div class="rows">
                                <textarea id="message" name="message" style="color: black;font-family: majalla;font-size:22px;margin-top: 0px; width: 222px; height: 90px;" required="required"></textarea> 
                                &nbsp;&nbsp;&nbsp;
                                <button class="btn btn-danger"  type="reset" onclick="clear();" style="font-weight: bold;color: black; width: 80px;font-size:14px; float:right; margin-top:0px; margin-bottom: 20px;">Clear</button>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-danger" formaction="../AudioUpload"  type="submit" style="font-weight: bold; color: black;width: 90px; font-size:24px; font-family: majalla;float:left; margin-top:26px; margin-bottom: 20px;margin-right: 20px;">Encoding</button>
                            </div>  
                            &nbsp;&nbsp;&nbsp;
                            <div class="form-group">
                                <button class="btn btn-danger" formaction="../AudioDecode" type="submit" style="font-weight: bold; color: black;width: 90px; font-size:24px; font-family: majalla;float:left; margin-top:26px; margin-bottom: 20px;margin-left: 0px;">Decoding</button>
                            </div>                     
                        </div>
                    </div>
                </form>
            </div>
        </div> 
        <%

            String DecodeMessage = request.getParameter("message");
            if (DecodeMessage != null) {
        %>
        <script>
            document.getElementById("message").value = "<%=DecodeMessage%>";
        </script>

        <%                               }
        %>

        <%
            String outpath = request.getParameter("outpath");
            if (outpath != null) {
        %>
        <a href="../uploads/<%=outpath%>" class="btn btn-info" role="button" style="margin-left: 367px; color: white;" >
            <span class="glyphicon glyphicon-download"></span>Download</a>    

        <%                               }
        %>
    </body>
</html>
