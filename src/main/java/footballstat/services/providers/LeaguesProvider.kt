package footballstat.services.providers

import footballstat.model.football.Team
import footballstat.services.DataItems
import footballstat.services.ExternalProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

class LeaguesProvider
{
    @Component
    open class ExternalLeaguesProvider : DataItems.Leagues
    {
        @Autowired
        lateinit var externalProvider : ExternalProvider

        override fun getLeague(leagueId: Int, year: Int): Collection<Team>
        {
            val response = externalProvider.getResponse("http://api.football-data.org/v1/competitions/426/leagueTable")
            return emptyList()
        }
    }
}