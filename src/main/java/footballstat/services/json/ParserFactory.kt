package footballstat.services.json

import footballstat.model.football.League
import org.springframework.stereotype.Component

@Component
class ParserFactory
{
    fun getParser(leagueType: League.LeagueType) : TeamsParser
    {
        return when (leagueType)
        {
            League.LeagueType.TOURNAMENT -> FDOTournamentTeamsParser()
            League.LeagueType.CUP -> FDOCupTeamsParser()
            else -> throw IllegalArgumentException("League type is $leagueType")
        }
    }
}