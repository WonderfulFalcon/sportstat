<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="league-filters">
    <span>
        Match day:
    </span>
    <select id="matchDay" name="Match Day">
        <c:forEach begin="1" end="${league.matchDay}" varStatus="loop">
            <option>
                    ${loop.count}
            </option>
        </c:forEach>
    </select>
</div>
