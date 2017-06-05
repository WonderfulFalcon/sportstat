<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>TemplateWorld.com Template - Web 2.0</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link href="images/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--top start -->
<div id="top">
    <p class="ph">
        <span>+01-4456-6678</span>
    </p>
    <ul>
        <li><a href="#" class="hover">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Solutions</a></li>
        <li><a href="#">Support</a></li>
        <li><a href="#">Testimonials</a></li>
        <li><a href="#">News and Events</a></li>
        <li><a href="#">Location</a></li>
        <li><a href="#">blog</a></li>
        <li class="noImg"><a href="#">Contact&nbsp;Us</a></li>
    </ul>
</div>
<!--top end -->
<!--body start -->
<div id="body">
    <!--left start -->
    <div id="left">
        <a href="index.html">
            <img src="images/logo.gif" alt="pot" width="149" height="106" class="logo" title="pot" />
        </a>
        <h2 class="moreLink">More Links</h2>
        <ul class="lftNav">
            <li><a href="#">Lectus aenean suscipit</a></li>
            <li><a href="#">Nunc ut dui</a></li>
            <li><a href="#">Aliquam ut augue morbi</a></li>
            <li><a href="#">Sem lacus</a></li>
            <li><a href="#">Vestibulum vitae</a></li>
            <li><a href="#">Sagittis atsagittis nec </a></li>
            <li><a href="#">Turpis</a></li>
            <li><a href="#">Pellentesque pharetra </a></li>
            <li class="noImg2"><a href="#">Leout adipiscing</a></li>
        </ul>
        <p class="lftBot"></p>
        <h2 class="catagory">Categories</h2>
        <ul class="lftNav">
            <li><a href="#">Cras commodo</a></li>
            <li><a href="#">Suspendisse purrasut</a></li>
            <li><a href="#">Leo neurna dictum</a></li>
            <li><a href="#">Consectetuer quisque</a></li>
            <li><a href="#">Felis</a></li>
            <li><a href="#">Aliquam erat volutpat</a></li>
            <li><a href="#">Ut ultrices nisi</a></li>
            <li><a href="#">Euismod accumsan</a></li>
            <li class="noImg2"><a href="#">Lectus nisi mollis arcu</a></li>
        </ul>
        <p class="lftBot"></p>
        <ul class="botLink">
            <li class="subscribe"><a href="#">Subscribe Here</a></li>
            <li class="tellFriend"><a href="#">Tell A Friend</a></li>
        </ul>
    </div>
    <!--left end -->
    <!--right start -->
    <div id="right">
        <!--rightTop start -->

        <div id="rightTop">
            <h1>containing most valuable informations</h1>
            <img src="images/free_registration.gif" alt="" width="121" height="110" border="0" usemap="#Map" class="freeReg" />
            <map name="Map" id="Map">
                <area shape="rect" coords="17,17,89,97" href="#" alt="" />
            </map>
            <form name="memberLogin" action="#" method="post">
                <label class="mem">Member Login</label>
                <input type="text" name="name" value="Enter Name" class="txtBox" />
                <input type="password" name="password" value="**********" class="txtBox" />
                <input type="submit" name="login" value="Login" class="btnLogin" />
                <label class="blank"></label>
                <label class="fp"><a href="#">Forgot Password ?</a></label>
                <label class="signup"><a href="#">Sign Up Now</a></label>
            </form>
            <ul>
                <li><a href="#" class="download">Download</a></li>
                <li><a href="#" class="question">Questions</a></li>
                <li><a href="#" class="addItem">Add Items</a></li>
                <li><a href="#" class="idea">Ideas</a></li>
                <li><a href="#" class="policy">Policies</a></li>
            </ul>
        </div>
        <!--rightTop end -->
        <!--rightLeft start -->
        <div id="rightLeft">
            <h2>England legue</h2>
            <ul>
                <c:forEach items="${teams}" var="team">
                    <li>${team.name}</li>
                </c:forEach>
            </ul>
        </div>
        <!--rightLeft end -->
        <!--last start -->
        <div id="last">
            <h2 class="sponsor">Sponsors Links</h2>
            <ul class="rightNav">
                <li><a href="#">Lectus @ aenean.com</a></li>
                <li><a href="#">suscipit@ Nunc.com</a></li>
                <li><a href="#">Aliquam@ut&nbsp;augue.com</a></li>
                <li><a href="#">morbi@Sem.com</a></li>
                <li class="noImg3"><a href="#">Vestibulum@vitae.com</a></li>
            </ul>
            <p class="rightBot"></p>
            <ul class="rightBotLink">
                <li class="job"><a href="#">Join Now</a></li>
                <li class="event"><a href="#">Join Now</a></li>
                <li class="bookmark"><a href="#">Bookmark The Page</a></li>
            </ul>
        </div>
        <!--last end -->
        <!--update start -->
        <div id="update">
            <h2>Latest Updates</h2>
            <h3>On 01st October 2007</h3>
            <p class="updateTxt">
                Mauris tempus mi vehicula ipsum. Donec gravida mattis dui. Etiam tempor <span>neque non tellus.</span> Nunc vite 	 				velit ut purus pellentesque adipiscing. Integer estIn justo elit, pellentesque at,
            </p>
            <a href="#" class="more">Read More</a>
            <br class="spacer" />
        </div>
        <!--update end -->
        <!--update start -->
        <div id="service">
            <h2>Current Services</h2>
            <h3>Fusce tempus</h3>
            <ul>
                <li><a href="#">Mauris tempus mi vehicula ipsum. Donec gravida</a></li>
                <li><a href="#">Etiam tempor neque non tellus</a></li>
                <li><a href="#">Nunc vitae velit ut purus pellentesque</a></li>
            </ul>
            <a href="#" class="more2">Read More</a>
            <br class="spacer" />
        </div>
        <!--update end -->
        <br class="spacer" />
    </div>
    <!--right end -->
    <br class="spacer" />
</div>
<!--body end -->
<!--footer start -->
<div id="footerMain">

    <div id="footer">
        <ul>
            <li><a href="#">Home</a> |</li>
            <li><a href="#">About Us</a> |</li>
            <li><a href="#">Solutions</a> |</li>
            <li><a href="#">Support</a> |</li>
            <li><a href="#">Testimonials</a> |</li>
            <li><a href="#">News and Events</a> |</li>
            <li><a href="#">Location</a> |</li>
            <li><a href="#">blog</a> |</li>
            <li><a href="#">Contact&nbsp;Us</a></li>
        </ul>
        <p class="copyright">Copyright © Pot 20XX. All Rights Reserved.</p>
        <a href="http://validator.w3.org/check?uri=referer" class="xhtml">XHTML</a>
        <a href="http://jigsaw.w3.org/css-validator/check/referer" class="css">Css</a>

    </div>
</div>
<!--footer end -->
</body>
</html>

