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

        fun getLeague(leagueId: String, matchDay: Int) : League

        fun getMatches(leagueId: String, matchDay: Int) : Set<Match>

        fun getMatches(leagueId: String) : Set<Match>
    }
}