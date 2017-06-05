package footballstat.services.providers

import footballstat.model.Country
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import footballstat.services.DataItems
import footballstat.services.ExternalProvider

class TeamsProvider
{
    @Component
    open class ExternalTeamsProvider : DataItems.Teams
    {
        @Autowired
        lateinit var externalProvider: ExternalProvider

        override fun getTeam(teamId: Int): Team
        {
            val response = externalProvider.getResponse("http://api.football-data.org/v1/competitions/426/leagueTable")
            return Team("Manchester", Country("England"))
        }
    }
}