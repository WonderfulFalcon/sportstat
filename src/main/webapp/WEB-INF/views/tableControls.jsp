<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h6>Match day</h6>
<div>
    <select name="Match Day" multiple="multiple">
        <c:forEach begin="1" end="${league.matchDay}" varStatus="loop">
            <option>
                ${loop.count}
            </option>
        </c:forEach>
    </select>
</div>

<h6>Season</h6>