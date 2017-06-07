package footballstat.services.providers

import footballstat.config.business.FootballDataOrgConfig
import footballstat.model.football.Player
import footballstat.model.football.Team
import org.springframework.stereotype.Component
import footballstat.services.DataItems
import org.apache.http.client.fluent.Request
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired


class TeamsProvider
{
    @Component
    open class ExternalTeamsProvider : DataItems.Teams
    {
        @Autowired
        lateinit var externalConfig: FootballDataOrgConfig

        private val objectMapper = ObjectMapper()

        override fun getTeamSquad(teamId: Int): Collection<Player>
        {

//            val request = Request.Get("${externalConfig.competitionUrl}/$teamId/${externalConfig.leagueSuffix}")
//            request.addHeader("X-Auth-Token", externalConfig.xAuthToken)
//            request.addHeader()
            return emptyList()
        }
    }
}