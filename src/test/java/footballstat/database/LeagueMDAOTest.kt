package footballstat.database

import footballstat.database.dao.mongodb.LeaguesMDAO
import footballstat.model.football.League
import footballstat.model.football.Table
import footballstat.model.football.Team
import footballstat.services.json.LeagueParser
import org.codehaus.jackson.map.ObjectMapper
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.Criteria.*
import org.springframework.test.context.TestPropertySource

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations= arrayOf("classpath:config/testdata/league-mdao-test.properties"))
open class LeagueMDAOTest
{
    @Autowired
    lateinit var leagueDAO : LeaguesMDAO

    @Autowired
    lateinit var leagueParser : LeagueParser

    @Value("\${league}")
    private val requestGetLeague: String = ""

    @Value("\${listLeagueInfo}")
    private val requestListLeagueInfo: String = ""
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
    fun leagueTest()
    {
        val league = leagueParser.league(requestGetLeague)
        leagueDAO.insert(league)
        val leagueFromDB = leagueDAO.findOne(league.id)
    }

    @Test
    fun leagueInfoTest()
    {
        var leagueList = leagueParser.availableLeagues(requestListLeagueInfo)
    }
}