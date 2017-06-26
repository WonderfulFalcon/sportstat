<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="col1">
    <h3>League summary</h3>
    <table>
        <tbody>
            <tr>
                <td>
                    Match days
                </td>
                <td>
                    ${leagueSummary.round}
                </td>
            </tr>
            <tr>
                <td>
                    Total goals
                </td>
                <td>
                    ${leagueSummary.totalGoals}
                </td>
            </tr>
            <tr>
                <td>
                    Match average goals
                </td>
                <td>
                    ${leagueSummary.averageMatchGoals}
                </td>
            </tr>
        </tbody>
    </table>
</div>

<div id="col2">
    <c:forEach items="${league.tables}" var="league">
        <h3>${league.name}</h3>
        <table class="league-table">
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
                    <td class="teamColumn">
                        <div data-clickable-team="${team.id}">
                            <span>
                                ${team.name}
                            </span>
                        </div>
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
    </c:forEach>

    <h3>
        Match results:
    </h3>

    <table>
        <c:forEach items="${matches}" var="match">
            <tr>
                <td>
                    <span>
                        ${match.homeTeamName}
                    </span>
                </td>
                <td>
                    <span>
                        ${match.goalsHomeTeam}
                    </span>
                </td>
                <td>
                    <span>
                        -
                    </span>
                </td>
                <td>
                    <span>
                        ${match.goalsAwayTeam}
                    </span>
                </td>
                <td>
                    <span>
                        ${match.awayTeamName}
                    </span>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

