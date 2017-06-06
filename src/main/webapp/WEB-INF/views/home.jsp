<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>FOOTBALLstat</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value="/js/HomeController.js" /> "></script>
</head>
<body>
<div id="header">
    <p class="logotext">Football<strong>Stat</strong><br>
        <span class="logotext2">Your slogan goes here</span>
    </p>
</div>
<div id="gutter"></div>
<div id="col2">
    <jsp:include page="leagueTable.jsp" flush="true" />
</div>
<div id="col3">
    <jsp:include page="tableControls.jsp" flush="true" />
</div>
<div id="footer"> <a href="#">homepage</a></div>
</body>
</html>


