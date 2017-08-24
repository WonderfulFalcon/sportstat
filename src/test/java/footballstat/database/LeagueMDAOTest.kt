package footballstat.database

import footballstat.database.dao.mongodb.LeaguesMDAO
import footballstat.model.football.League
import footballstat.model.football.Table
import footballstat.model.football.Team
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.Criteria.*

@RunWith(SpringRunner::class)
@SpringBootTest
open class LeagueMDAOTest
{
    @Autowired
    lateinit var leagueDAO : LeaguesMDAO
//
//    @Test
//    fun getAll()
//    {
//        val country : CountryEntity = CountryEntity(0, "Test")
//        countryDAO.insert(country)
//        val countries = countryDAO.findAll()
//        Assert.assertNotNull(countries)
//        Assert.assertTrue(countries.isNotEmpty())
//    }
//
//    @Test
//    fun delete()
//    {
//        val country : CountryEntity = CountryEntity(0, "Test")
//        val insertedCountry = countryDAO.insert(country)
//        if (insertedCountry != null) {
//            countryDAO.remove(insertedCountry.Id)
//            val deletedCountry = countryDAO.findOne(insertedCountry.Id)
//            Assert.assertNull(deletedCountry)
//        }
//    }
//
//    @Test
//    fun insert()
//    {
//        val country : CountryEntity = CountryEntity(0, "Test")
//        val insertedCountry = countryDAO.insert(country)
//        Assert.assertNotNull(insertedCountry)
//    }

    @Test
    fun tst()
    {
        val league : League = with(League()) {
            Id = 1
            MatchDay = 1
            Name="Hueliga"
            Year=1999
            Type=League.LeagueType.TOURNAMENT
            Tables=buildTable()
            this
        }
        leagueDAO.insert(league)
        println("zalupa iz bazy ${leagueDAO.findOne(league.id)}")
    }

    private fun buildTable(): ArrayList<Table> {
        val result = ArrayList<Table>()
        result.add(with(Table()) {
            Name="HueTable"
            Teams=buildTeams()
            this
        })

        return result
    }

    private fun buildTeams(): ArrayList<Team> {
        val result = ArrayList<Team>()
        result.add(with(Team(100)) {
            Name="HueTeam"
            this
        })

        return result
    }
}