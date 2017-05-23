package services

import database.dao.CountryDAO
import model.Country
import model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Component

@Component
class SportDataService() : SportData
{

    @Lazy
    @Autowired
    val countryDAO: CountryDAO = CountryDAO(DriverManagerDataSource())

    override fun getTeam(teamId: Int): Team
    {
        throw UnsupportedOperationException()
    }

    override fun getLeague(countryId: Int): Collection<Team>
    {
        throw UnsupportedOperationException()
    }

    override fun getCountries(): Collection<Country>
    {
        try
        {
            return countryDAO.getAllCounties().map{ c -> Country(c.name) }
        }
        catch(e : RuntimeException)
        {
            return emptyList();
        }
    }
}