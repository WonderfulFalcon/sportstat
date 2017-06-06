<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>FOOTBALLstat</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/HomeController.js" /> "></script>
</head>
<body>
<div id="header">
    <p class="logotext">Football<strong>Stat</strong><br>
        <span class="logotext2">Your slogan goes here</span></p>
    <div id="headinfo">
        <img src="images/sitemap.gif"> <a href="#">Sitemap</a> | <img src="images/contact.gif"> <a href="#">Contact Us</a>
    </div>

</div>
<div id="gutter"></div>
<div id="col1">
    <jsp:include page="leagueTable.jsp" flush="true" />
</div>
<div id="col2">
    <jsp:include page="tableControls.jsp" flush="true" />
</div>
<div id="col3">
    <div id="navcontainer">
        <ul id="navlist">
            <li class="links">Navigate</li>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Portfolio</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#">Contact</a></li>
            <li class="links">Archives</li>
            <li><a href="#">April 2007</a></li>
            <li><a href="#">March 2007</a></li>
            <li><a href="#">Feb 2007</a></li>
            <li><a href="#">Jan 2007</a></li>
            <li><a href="#">Dec 2006</a></li>
            <li><a href="#">Nov 2006</a></li>
        </ul>
    </div>
</div>
<div id="footer"> <a href="#">homepage</a> | <a href="#">contact</a> | &copy; 2017 Anyone | Design by no-name | Licensed under a free </div>
</body>
</html>


