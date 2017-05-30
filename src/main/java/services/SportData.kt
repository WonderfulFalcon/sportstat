package services


import model.Country
import model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SportData : DataItems.Leagues, DataItems.Countries, DataItems.Teams
{
    @Autowired
    lateinit var countries : DataItems.Countries

    @Autowired
    lateinit var teams : DataItems.Teams

    override fun getTeam(teamId: Int): Team
    {
        return teams.getTeam(teamId)
    }

    override fun getLeague(countryId: Int): Collection<Team>
    {
        throw UnsupportedOperationException()
    }

    override fun getCountries(): Collection<Country>
    {
        try
        {
            return countries.getCountries();
        }
        catch(e : RuntimeException)
        {
            return emptyList();
        }
    }
}