package footballstat.services

import footballstat.model.football.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

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

    override fun getLeague(leagueId: String, matchDay: Int) : League
    {
        return leagues.getLeague(leagueId, matchDay)
    }

    override fun getMatches(leagueId: String, matchDay: Int) : Set<Match>
    {
        return leagues.getMatches(leagueId, matchDay)
    }

    override fun getMatches(leagueId: String): Set<Match> {
        return leagues.getMatches(leagueId);
    }

    fun getLeague(leagueId: String) : League
    {
        return leagues.getLeague(leagueId, 1)
    }

    fun getTeamsForm(leagueId: String, matchesCount: Int) : List<TeamForm>
    {
        val teamForms : ArrayList<TeamForm> = ArrayList()

        val league : League = getLeague(leagueId)

        val toursMatches : List<Set<Match>> = getToursMatches(league)
        val teams = league.Teams ?: Collections.emptyList()

        for (team in teams)
        {
            val teamMatches : ArrayList<Match> = ArrayList()
            var tourIndex = 0
            while (teamMatches.size < matchesCount && tourIndex < toursMatches.size)
            {
                teamMatches.addAll(
                    toursMatches.get(tourIndex).filter {
                        Objects.equals(team.Name, it.AwayTeamName) || Objects.equals(team.Name, it.HomeTeamName)
                    }
                )

                tourIndex++
            }

            teamForms.add(TeamForm(team, teamMatches))
        }

        return teamForms
    }

    //может сюда вкрчить ограничение по кол-ву результатов ???
    /**
     * Return tours matches, sorted by MatchDay (last match .. old match)
     */
    private fun getToursMatches(league : League) : List<Set<Match>>
    {
        val tourMatches : ArrayList<Set<Match>> = ArrayList()
        val allMatches : Set<Match> = getMatches(league.id!!)

        var matchDay : Int = league.ToursPlayed ?: 0

        while (matchDay != 0)
        {
            tourMatches.add(allMatches
                    .filter { it.matchDay == matchDay }
                    .toSet())
            matchDay--
        }
        return tourMatches;
    }
}