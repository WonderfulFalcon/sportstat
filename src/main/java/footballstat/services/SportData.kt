package footballstat.services

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.model.football.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class SportData : DataItems.Leagues, DataItems.Teams
{
    @Autowired
    lateinit var teams : DataItems.Teams

    @Autowired
    lateinit var leagues : DataItems.Leagues

    override fun getAvailableLeagues(): List<LeagueInfo>
    {
        return leagues.getAvailableLeagues()
    }

    override fun getTeamSquad(teamId : Int): Collection<Player>
    {
        return teams.getTeamSquad(teamId)
    }

    override fun getLeague(leagueId : Int, matchDay : Int) : League
    {
        return leagues.getLeague(leagueId, matchDay)
    }

    override fun getMatches(leagueId : Int, matchDay : Int) : Set<Match>
    {
        return leagues.getMatches(leagueId, matchDay)
    }
}