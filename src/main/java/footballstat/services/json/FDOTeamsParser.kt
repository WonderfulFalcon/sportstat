package footballstat.services.json

import footballstat.model.football.League
import footballstat.model.football.Team
import footballstat.model.football.TournamentStatistic
import org.codehaus.jackson.JsonNode
import org.springframework.stereotype.Component
import java.util.*

@Component
class FDOTeamsParser
{
    fun getTeams(standings : JsonNode, leagueType : League.LeagueType) : ArrayList<Team>
    {
        val teams = ArrayList<Team>()
        for (element in standings.elements) {
            val id = getTeamId(leagueType, element)
            if (id != null)
            {
                val team = Team(id)
                team.Name = getTeamName(leagueType, element)
                team.Statistic = tournamentStatistic(leagueType, element)
                teams.add(team)
            }
        }
        return teams
    }

    private fun getTeamId(leagueType: League.LeagueType, element : JsonNode) : Int?
    {
        if (leagueType == League.LeagueType.TOURNAMENT)
        {
            val urlArray = (element.get("_links").get("team").get("href")).textValue?.split('/')
            if (urlArray != null)
            {
                return urlArray[urlArray.size - 1].toInt()
            }
        }
        else if (leagueType == League.LeagueType.CUP)
        {
            return element.get("teamId")?.intValue
        }
        return null
    }

    private fun getTeamName(leagueType: League.LeagueType, jsonNode: JsonNode) : String?
    {
        if (leagueType == League.LeagueType.TOURNAMENT)
        {
             return jsonNode.get("teamName")?.textValue
        }
        return jsonNode.get("team")?.textValue
    }

    private fun tournamentStatistic(leagueType: League.LeagueType, jsonNode: JsonNode) : TournamentStatistic
    {
        if (leagueType == League.LeagueType.TOURNAMENT)
        {
            return with(TournamentStatistic())
            {
                PlayedGames = jsonNode.get("playedGames").intValue
                Points = jsonNode.get("points").intValue
                GoalsScored = jsonNode.get("goals").intValue
                GoalsAgainst = jsonNode.get("goalsAgainst").intValue
                GoalsDifference = jsonNode.get("goalDifference").intValue

                Position = jsonNode.get("position").intValue
                Wins = jsonNode.get("wins").intValue
                Draws = jsonNode.get("draws").intValue
                Losses = jsonNode.get("losses").intValue
                this
            }
        }
        return with(TournamentStatistic())
        {
            PlayedGames = jsonNode.get("playedGames").intValue
            Points = jsonNode.get("points").intValue
            GoalsScored = jsonNode.get("goals").intValue
            GoalsAgainst = jsonNode.get("goalsAgainst").intValue
            GoalsDifference = jsonNode.get("goalDifference").intValue
            this
        }
    }
}