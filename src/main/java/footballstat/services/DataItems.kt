package footballstat.services

import footballstat.model.Country
import footballstat.model.football.League
import footballstat.model.football.Player

interface DataItems
{
    interface Countries
    {
        fun getCountries() : Collection<Country>
    }

    interface Teams
    {
        fun getTeamSquad(teamId : Int) : Collection<Player>
    }

    interface Leagues
    {
        fun getCurrentLeague(leagueId: Int) : League

        fun getLeague(leagueId : Int, year: Int) : League

        fun getLeague(leagueId: Int, year: Int, matchDay : Int) : League
    }
}