
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Team squad</h3>
<table>
    <thead>
        <tr>
            <th>
                Name
            </th>
            <th>
                Position
            </th>
            <th>
                Number
            </th>
            <th>
                Citizenships
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>
                ${player.name}
            </td>
            <td>
                ${player.position}
            </td>
            <td>
                ${player.number}
            </td>
            <td>
                ${player.citizenships}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>