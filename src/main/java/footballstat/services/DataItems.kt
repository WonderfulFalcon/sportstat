package footballstat.services

import footballstat.model.Country
import footballstat.model.football.League
import footballstat.model.football.Team
import java.time.Year

interface DataItems
{
    interface Countries
    {
        fun getCountries() : Collection<Country>
    }

    interface Teams
    {
        fun getTeam(teamId : Int) : Team
    }

    interface Leagues
    {
        fun getCurrentLeague(leagueId: Int) : League

        fun getLeague(leagueId : Int, year: Int) : League
    }
}