<%
    session = request.getSession();
    String First_Name = (String) session.getAttribute("First_Name");
    First_Name = First_Name.toUpperCase();
%>
<link rel="stylesheet" href="../css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="../css/style.css"> <!-- Gem style -->
<script src="../js/modernizr.js"></script> <!-- Modernizr -->
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


<%@include file="ForAll2.jsp" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=""><img src="../images/Logo.jpg" style="width:157px;height:45px;"/></a>
            <a class="navbar-brand" style="color: white; margin-top: 20px; margin-right: 100px;">go unseen....</a>
        </div>
        <ul class="nav navbar-nav" style="padding-left: 80px;">
            <li class="dropdown"><a href="../home.jsp"><br>HOME</a></li>
            <li class="dropdown"><a href="../work.jsp"><br>WORK</a></li>
            <li class="active"><a class="dropdown-toggle" data-toggle="dropdown"><br>TOOLS<span class="caret"></span></a>
                <ul class="dropdown-menu" style="padding-top: 0px;">
                    <li><a href="Video_Audio.jsp">Video and Audio Steganography</a></li>
                    <li><a href="Stegno-Crypt.jsp">Stegno-Crypt</a></li>
                    <li><a href="backup.jsp">Backup Utility</a></li>
                    <li><a href="screenrec.jsp">Screen Recorder</a></li>
                </ul>
            </li>
            <li class="dropdown"><a href="../Contactus.jsp"><br>CONTACT US</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right" style="padding-top:20px;">

            <li><a href="#" data-toggle="modal" data-target="#AccountModal"><span class="glyphicon glyphicon-user"></span> <%=First_Name%> </a></li>
            <li><a href="../Logout.jsp"><span class="glyphicon glyphicon-log-out"></span> LOG OUT</a></li>
        </ul>
    </div>
</nav>

<%@include file="../LoginPopUp.jsp" %>