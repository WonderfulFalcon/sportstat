package footballstat.services.json

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match

interface LeagueParser
{
    fun availableLeagues(json: String) : List<LeagueInfo>

    fun matches(json: String) : List<Match>

    fun league(json: String) : League
}