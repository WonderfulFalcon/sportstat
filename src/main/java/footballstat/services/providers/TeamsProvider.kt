package footballstat.services.providers

import footballstat.model.football.Team
import org.springframework.stereotype.Component
import footballstat.services.DataItems


class TeamsProvider
{
    @Component
    open class ExternalTeamsProvider : DataItems.Teams
    {
        override fun getTeam(teamId: Int): Team
        {
            return Team()
        }
    }
}