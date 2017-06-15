package footballstat.services

import footballstat.model.Country
import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
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
        fun getAvailableLeagues() : List<LeagueInfo>

        fun getLeague(leagueId : Int, matchDay : Int) : League

        fun getMatches(leagueId : Int, matchDay : Int) : Set<Match>
    }
}