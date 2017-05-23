package services


import database.dao.DAO
import model.Country
import model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SportDataService() : SportData
{
    @Autowired
    lateinit var countryDAO: DAO<database.entity.Country>

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
            return countryDAO.getAll().map{ c -> Country(c.name) }
        }
        catch(e : RuntimeException)
        {
            return emptyList();
        }
    }
}