package services

import model.Country
import model.football.Team

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
        fun getLeague(countryId : Int) : Collection<Team>
    }
}