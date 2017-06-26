package footballstat.services.json

import footballstat.model.football.TournamentStatistic
import org.codehaus.jackson.JsonNode

class FDOTournamentTeamsParser : TeamsParser()
{
    override fun teamId(jsonNode: JsonNode) : Int?
    {
        val urlArray = (jsonNode.get("_links").get("team").get("href")).textValue?.split('/')
        if (urlArray != null)
        {
            return urlArray[urlArray.size - 1].toInt()
        }
        return null

    }

    override fun teamName(jsonNode: JsonNode): String?
    {
        return jsonNode.get("teamName")?.textValue
    }

    override fun tournamentStatistic(jsonNode: JsonNode) : TournamentStatistic
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
}