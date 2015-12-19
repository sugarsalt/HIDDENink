
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="Title.jsp" %>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Fullscreen Slit Slider with CSS3 and jQuery" />
        <meta name="keywords" content="slit slider, plugin, css3, transitions, jquery, fullscreen, autoplay" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style_1.css" />
        <link rel="stylesheet" type="text/css" href="css/custom.css" />
        <script type="text/javascript" src="js/modernizr.custom.79639.js"></script>
        <noscript>
        <link rel="stylesheet" type="text/css" href="css/styleNoJS.css" />
        </noscript>
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
                background-size: 100% 100%;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
            <%@include file="ForAll.jsp" %>
        </style>
    </head>
    <body>
        <div>
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
                    <ul class="nav navbar-nav" style="padding-left: 80px;">
                        <li class="dropdown"><a href="home.jsp"><br>HOME</a></li>
                        <li class="active"><a href="work.jsp"><br>WORK</a></li>
                        <li class="dropdown"><a href="Contactus.jsp"><br>CONTACT US</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="padding-top:20px;">
                        <li><a href="#" data-toggle="modal" data-target="#SignupModal"><span class="glyphicon glyphicon-user"></span> SIGN UP</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#LoginModal"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#AdminModal"><span class="glyphicon glyphicon-star"></span></a></li>


                        <%                                    } else {
                            First_Name = First_Name.toUpperCase();

                        %>
                        <ul class="nav navbar-nav" style="padding-left: 80px;">
                            <li class="dropdown"><a href="home.jsp"><br>HOME</a></li>
                            <li class="active"><a href="work.jsp"><br>WORK</a></li>
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
        </div>
        <div class="container demo-1" style="margin-top: 67px;height: 600px;;width: 100%;">
            <div id="slider" class="sl-slider-wrapper">

                <div class="sl-slider">

                    <div class="sl-slide bg-2" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
                        <div class="sl-slide-inner">
                            <div class="deco" data-icon="I" style="color: black;"></div>
                            <h2>AUDIO and VIDEO STEGANOGRAPHY</h2>
                            <blockquote><p>Hiding your information inside the audio waves and video waves</p><cite>Message inside Video & Audio</cite></blockquote>
                        </div>
                    </div>
                    <div class="sl-slide bg-4" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
                        <div class="sl-slide-inner">
                            <div class="deco" data-icon="S"></div>
                            <h2>IMAGES STEGANOGRAPHY with CRYPTOGRAPHY</h2>
                            <blockquote><p>Encryption performed on the message and then making invisible within a Image</p><cite>Steganography + Cryptography = Stegno-Crypt</cite></blockquote>
                        </div>
                    </div>
                    <div class="sl-slide bg-5" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="deco" data-icon="K"></div>
                            <h2>BACKUP UTILITY</h2>
                            <blockquote><p>A tool which copies database and stores it in the form of zip file</p><cite>KEEP CALM and Take the BACKUP</cite></blockquote>
                        </div>
                    </div>

                    <div class="sl-slide bg-3" data-orientation="vertical" data-slice1-rotation="-5" data-slice2-rotation="25" data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="deco" data-icon="d"></div> 

                            <h2>SCREEN RECORDING</h2>
                            <blockquote><p>A tool which provides desktop as well as webcam recording with audio</p><cite>Record every move</cite></blockquote>
                        </div>
                    </div>
                    <div class="sl-slide bg-1" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="deco" data-icon="t"></div>
                            <h2>ENCRYPTION TECHNIQUES</h2>
                            <blockquote>Changing your Message by shuffling the alphabets in such a manner that it will difficult for intruders to understand<p></p><cite>To make your communication secure</cite></blockquote>
                        </div>
                    </div>

                </div>

                <!-- /sl-slider -->

                <nav id="nav-arrows" class="nav-arrows">
                    <span class="nav-arrow-prev">Previous</span>
                    <span class="nav-arrow-next">Next</span>
                </nav>

                <nav id="nav-dots" class="nav-dots" style="padding-top: 0px;">
                    <span class="nav-dot-current"></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </nav>

            </div><!-- /slider-wrapper -->

        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.ba-cond.min.js"></script>
        <script type="text/javascript" src="js/jquery.slitslider.js"></script>
        <script type="text/javascript">
            $(function() {

                var Page = (function() {

                    var $navArrows = $('#nav-arrows'),
                            $nav = $('#nav-dots > span'),
                            slitslider = $('#slider').slitslider({
                        onBeforeChange: function(slide, pos) {

                            $nav.removeClass('nav-dot-current');
                            $nav.eq(pos).addClass('nav-dot-current');

                        }
                    }),
                    init = function() {

                        initEvents();

                    },
                            initEvents = function() {

                        // add navigation events
                        $navArrows.children(':last').on('click', function() {

                            slitslider.next();
                            return false;

                        });

                        $navArrows.children(':first').on('click', function() {

                            slitslider.previous();
                            return false;

                        });

                        $nav.each(function(i) {

                            $(this).on('click', function(event) {

                                var $dot = $(this);

                                if (!slitslider.isActive()) {

                                    $nav.removeClass('nav-dot-current');
                                    $dot.addClass('nav-dot-current');

                                }

                                slitslider.jump(i + 1);
                                return false;

                            });

                        });

                    };

                    return {init: init};

                })();

                Page.init();

                /**
                 * Notes: 
                 * 
                 * example how to add items:
                 */

                /*
                 
                 var $items  = $('<div class="sl-slide sl-slide-color-2" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1"><div class="sl-slide-inner bg-1"><div class="sl-deco" data-icon="t"></div><h2>some text</h2><blockquote><p>bla bla</p><cite>Margi Clarke</cite></blockquote></div></div>');
                 
                 // call the plugin's add method
                 ss.add($items);
                 
                 */

            });
        </script>

        <%@include file="LoginPopUp.jsp" %>

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