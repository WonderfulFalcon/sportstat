package footballstat.services.json

import footballstat.model.football.HomeAwayStatistic
import org.codehaus.jackson.node.ObjectNode
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

            val homeJson = jsonNode.get("home") as? ObjectNode
            val awayJson = jsonNode.get("away") as? ObjectNode

            HomeStatistic = if (homeJson != null) getHomeAwayStatistic(homeJson) else HomeAwayStatistic()
            AwayStatistic = if (awayJson != null) getHomeAwayStatistic(awayJson) else HomeAwayStatistic();

            this
        }
    }

    private fun getHomeAwayStatistic(json: ObjectNode) : HomeAwayStatistic
    {
        return with(HomeAwayStatistic()) {
            Goals = json.get("goals").intValue
            GoalsAgainst = json.get("goalsAgainst").intValue
            Wins = json.get("wins").intValue
            Draws = json.get("draws").intValue
            Losses = json.get("losses").intValue
            this
        }
    }
}