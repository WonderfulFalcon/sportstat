package footballstat.services.json

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.model.football.TournamentStatistic
import org.codehaus.jackson.JsonNode

interface LeagueParser
{
    fun availableLeagues(jsonNode: JsonNode) : List<LeagueInfo>

    fun match(jsonNode: JsonNode) : Match

    fun league(jsonNode: JsonNode) : League

    fun tournamentStatistic(jsonNode: JsonNode) : TournamentStatistic
}