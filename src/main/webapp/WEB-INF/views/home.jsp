<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>TITLE</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${teams}" var="team">
                <li>${team.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>