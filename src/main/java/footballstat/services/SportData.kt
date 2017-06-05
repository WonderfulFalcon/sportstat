package footballstat.services


import footballstat.model.football.League
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class SportData : DataItems.Leagues, DataItems.Teams
{
    @Autowired
    lateinit var teams : DataItems.Teams

    @Autowired
    lateinit var leagues : DataItems.Leagues

    override fun getTeam(teamId: Int): Team
    {
        return teams.getTeam(teamId)
    }

    override fun getLeague(leagueId: Int, year: Int): League
    {
        return leagues.getLeague(leagueId, year)
    }
}