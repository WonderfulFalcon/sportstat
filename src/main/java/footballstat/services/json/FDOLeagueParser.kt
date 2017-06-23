package footballstat.services.json

import footballstat.model.football.*
import org.codehaus.jackson.JsonNode
import org.springframework.stereotype.Component

@Component
class FDOLeagueParser : LeagueParser
{
    override fun availableLeagues(jsonNode: JsonNode) : List<LeagueInfo>
    {
        return jsonNode.map {
            it ->  LeagueInfo(
                it.get("id").intValue,
                it.get("caption").textValue,
                it.get("currentMatchday").intValue)
        }
    }

    override fun match(jsonNode: JsonNode) : Match
    {
        return with(Match()) {
            MatchDay = jsonNode.get("matchday").intValue
            HomeTeamName = jsonNode.get("homeTeamName")?.textValue
            AwayTeamName = jsonNode.get("awayTeamName")?.textValue
            GoalsHomeTeam = jsonNode.get("result").get("goalsHomeTeam")?.intValue
            GoalsAwayTeam = jsonNode.get("result").get("goalsAwayTeam")?.intValue
            this
        }
    }

    override fun league(jsonNode: JsonNode) : League
    {
        val league = with(League()) {
            Name = jsonNode.get("leagueCaption")?.textValue
            MatchDay =  jsonNode.get("matchday").intValue
            this
        }

        val standings = jsonNode.get("standing")

        for (element in standings.elements) {
            val urlArray = (element.get("_links").get("team").get("href")).textValue?.split('/')
            val id = if (urlArray != null) urlArray[urlArray.size - 1].toInt() else null

            if (id != null)
            {
                val team = Team(id)

                team.Name = element.get("teamName")?.textValue
                team.Statistic = tournamentStatistic(element)
                league.Teams.add(team)
            }
        }
        return league
    }

    override fun tournamentStatistic(jsonNode: JsonNode) : TournamentStatistic
    {
        return with(TournamentStatistic())
        {
            PlayedGames = jsonNode.get("playedGames").intValue
            Position = jsonNode.get("position").intValue
            Points = jsonNode.get("points").intValue
            GoalsScored = jsonNode.get("goals").intValue
            GoalsAgainst = jsonNode.get("goalsAgainst").intValue
            GoalsDifference = jsonNode.get("goalDifference").intValue
            Wins = jsonNode.get("wins").intValue
            Draws = jsonNode.get("draws").intValue
            Losses = jsonNode.get("losses").intValue
            this
        }
    }
}