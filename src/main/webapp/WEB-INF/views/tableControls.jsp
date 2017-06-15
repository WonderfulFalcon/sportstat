<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="league-filters">

    <label for="leagueInfo">
        League:
    </label>
    <select id="leagueInfo">
        <c:forEach items="${leagueInfo}" var="info">
            <option data-league-id="${info.id}"
                    data-league-tours-played="${info.toursPlayed}">
                    ${info.name}
            </option>
        </c:forEach>
    </select>

    <label for="matchDay">
        Match day:
    </label>
    <select id="matchDay" name="Match Day">
    </select>
</div>
