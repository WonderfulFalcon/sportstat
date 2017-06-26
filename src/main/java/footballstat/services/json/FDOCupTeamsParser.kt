package footballstat.services.json

import footballstat.model.football.TournamentStatistic
import org.codehaus.jackson.JsonNode

class FDOCupTeamsParser : TeamsParser()
{
    override fun teamId(jsonNode: JsonNode) : Int?
    {
        return jsonNode.get("teamId")?.intValue
    }

    override fun teamName(jsonNode: JsonNode) : String?
    {
        return jsonNode.get("team")?.textValue
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
            this
        }
    }
}