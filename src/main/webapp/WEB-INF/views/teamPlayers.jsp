<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3 id="team-squad"></h3>
<table>
    <thead>
        <tr>
            <th>
                Country
            </th>
            <th>
                Name
            </th>
            <th>
                Number
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${players}" var="player">
        <tr>
            <td class="player-country">
                <i class="flag-${player.country}"></i>
            </td>
            <td>
                ${player.name}
            </td>
            <td>
                ${player.number}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>