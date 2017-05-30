package services.providers

import model.Country
import model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import services.DataItems
import services.ExternalProvider

class TeamsProvider
{
    @Component
    class ExternalCountriesProvider : DataItems.Teams
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