<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>FOOTBALLstat</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <p class="logotext">Football<strong>Stat</strong><br>
        <span class="logotext2">Your slogan goes here</span></p>
    <div id="headinfo">
        <img src="css/images/sitemap.gif"> <a href="#">Sitemap</a> | <img src="css/images/contact.gif"> <a href="#">Contact Us</a>
    </div>

</div>
<div id="gutter"></div>
<div id="col1">
    <h2>${league.name}</h2>
    <table>
        <thead>
            <tr>
                <th>
                    Pos.
                </th>
                <th>
                    Team
                </th>
                <th>
                    P
                </th>
                <th>
                    W
                </th>
                <th>
                    D
                </th>
                <th>
                    L
                </th>
                <th>
                    GS
                </th>
                <th>
                    GA
                </th>
                <th>
                    GD
                </th>
                <th>
                    Points
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${league.teams}" var="team">
                <tr>
                    <td>
                        ${team.statistic.position}
                    </td>
                    <td>
                        ${team.name}
                    </td>
                    <td>
                        ${team.statistic.playedGames}
                    </td>
                    <td>
                        ${team.statistic.wins}
                    </td>
                    <td>
                        ${team.statistic.draws}
                    </td>
                    <td>
                        ${team.statistic.losses}
                    </td>
                    <td>
                        ${team.statistic.goalsScored}
                    </td>
                    <td>
                        ${team.statistic.goalsAgainst}
                    </td>
                    <td>
                        ${team.statistic.goalsDifference}
                    </td>
                    <td>
                        ${team.statistic.points}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<div id="col2">
    <h2> News </h2>
    <div class="box">
        <span style="color:#FF9934; font-weight:bold;">Text1</span>
    </div>
    <div class="box">
        <span style="color:#FF9934; font-weight:bold;">Text2</span>
    </div>
    <form action="#" method="post">
        <fieldset>
            <legend>Search</legend>
            <div> <span>
      <label for="txtsearch"> <img src="css/images/search.gif" alt="search" /> :search</label>
      </span> <span>
      <input type="text" value="demo only" name="txtsearch" title="Text input: search" id="txtsearch" size="25" />
      </span> </div>
        </fieldset>
    </form>
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
            <li class="links">Articles</li>
            <li><a href="#">Article 1</a></li>
            <li><a href="#">Article 2</a></li>
            <li><a href="#">Article 3</a></li>
            <li><a href="#">Article 4</a></li>
            <li><a href="#">Article 5</a></li>
            <li><a href="#">Article 6</a> </li>
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


