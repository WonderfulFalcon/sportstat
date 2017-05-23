package services

import model.Country
import model.football.Team

interface FootballDataService
{
    fun getCountries() : Collection<Country>;

    fun getTeam(teamId : Int) : Team

    fun getLeague(countryId : Int) : Collection<Team>
}