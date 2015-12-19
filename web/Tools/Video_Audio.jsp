
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
                background-image: url("../images/Video_audio/VA.png");
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
               
            
        </style>
    </head>
    <body>
       <%@include file="WorksNav.jsp" %>
        <div class="container">
            <div class="rows" style="width: 100%;">
                <div class="col-xs-12" style="margin-top: 90px;min-height: 100px; "><br>
                    <a href="" style=" margin-left: 110px; color: white;font-family: Demo_ConeriaScript; font-size: 50px;" >Video and Audio Steganography</a></div>
            </div>
            <div class="col-xs-12" style="margin-left: 0px; padding-bottom: 30px; color: white;padding-top: 20px;font-family: Pink_Ladies; font-size: 30px;">
                <p> Video Steganography is the process of hiding some secret information inside a video. 
                    It is very essential to transmit important data like banking and military information in a secure manner. 
                    The addition of this information to the video is not recognizable by the human eye as the change of a pixel color is negligible. 
                    This application aims to provide an efficient and a secure method for video Steganography. 
                    <br>Audio Steganography is a technique used to transmit hidden information by modifying an audio signal in an imperceptible manner. 
                    It is the science of hiding some secret text. Data is hidden by modifying sample data.
                </p>
                <dl>
                    <dt>*Uncompressed audio formats</dt>
                    <dd>--- WAV(Waveform Audio File Format)</dd>
                    <dd>--- BWF(Broadcast Wave Format)</dd>
                    <dd>--- MBWF(Multichannel Broadcast Wave Format)</dd>
                    <dt>*Compressed audio formats</dt>
                    <dd>--- Lossy - Mp3,Advanced Audio Coding(AAC)</dd>
                    <dd>--- Lossless - Free Lossless Audio Codec(FLAC),Direct Stream Transfer(CST).</dd>
                </dl> 
            </div>
            <div class="col-xs-6" style="margin-right: 0px; margin-top: 0px; padding-left: 170px;">
                <div class="form-group">
                    <button style="font-family:Needlework;float:left; margin-top:4px; margin-bottom: 10px;" class="btn btn-danger"><a href="VideoSteg.jsp"style="color: white; font-size:28px; " >VIDEO STEGANOGRAPHY</a></button>
                </div> 
            </div>
            <div class="col-xs-6" style="margin-left:0px; margin-top: 0px; padding-left: 170px;">
                <div class="form-group">
                    <button style="font-family: Needlework;float:left; margin-top:4px; margin-bottom: 10px;" class="btn btn-danger"><a href="AudioSteg.jsp"style="color: white; font-size:28px; " >AUDIO STEGANOGRAPHY</a></button>
                </div> 
            </div>
        </div>     
    </body>
</html>
