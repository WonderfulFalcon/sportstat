<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="col1">
    <h3>Match results:</h3>
    <table class="match-results">
        <tbody>
            <c:forEach items="${matches}" var="match">
                <tr>
                    <td class="home-team"><span>${match.homeTeamName}</span></td>
                    <td class="scoreColumn">
                        <span>${match.goalsHomeTeam}</span>
                        <span>-</span>
                        <span>${match.goalsAwayTeam}</span>
                    </td>
                    <td class="away-team"><span>${match.awayTeamName}</span></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>League summary</h3>
    <table class="match-results">
        <tbody>
            <tr>
                <td class="home-team"><span>Match days</span></td>
                <td class="scoreColumn"><span>${leagueSummary.round}</span></td>
            </tr>
            <tr>
                <td class="home-team"><span>Total goals</span></td>
                <td class="scoreColumn"><span>${leagueSummary.totalGoals}</span></td>
            </tr>
            <tr>
                <td class="home-team"><span>Match average goals</span></td>
                <td class="scoreColumn">${leagueSummary.averageMatchGoals}</td>
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
                    <th><span>Pos.</span></th>
                    <th><span>Team</span></th>
                    <th><span>P</span></th>
                    <th><span>W</span></th>
                    <th><span>D</span></th>
                    <th><span>L</span></th>
                    <th><span>GS</span></th>
                    <th><span>GA</span></th>
                    <th><span>GD</span></th>
                    <th><span>Points</span></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${league.teams}" var="team">
                <tr>
                    <td><span>${team.statistic.position}</span></td>
                    <td class="teamColumn" data-clickable-team="${team.id}">
                        <div class="club-logo">
                            <img src="/images/clubs/England/${team.name}.svg" />
                        </div>
                        <div class="team-name">
                            <span>${team.name}</span>
                        </div>
                    </td>
                    <td><span>${team.statistic.playedGames}</span></td>
                    <td><span>${team.statistic.wins}</span></td>
                    <td><span>${team.statistic.draws}</span></td>
                    <td><span>${team.statistic.losses}</span></td>
                    <td><span>${team.statistic.goalsScored}</span></td>
                    <td><span>${team.statistic.goalsAgainst}</span></td>
                    <td><span>${team.statistic.goalsDifference}</span></td>
                    <td><span><b>${team.statistic.points}</b></span></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</div>

