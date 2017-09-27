package footballstat.database


import footballstat.database.dao.DAO
import footballstat.model.football.Match
import footballstat.services.json.LeagueParser
import org.codehaus.jackson.map.ObjectMapper
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations= arrayOf("classpath:config/testdata/mdao-test.properties"))
open class MatchDAOTest
{
    @Autowired
    lateinit var matchDAO : DAO<Match>

    @Autowired
    lateinit var leagueParser : LeagueParser

    @Value("\${matches}")
    private val matchesFDO: String = ""

    private var objectMapper : ObjectMapper = ObjectMapper()

    @Test
    fun testInsertDeleteGetbyid()
    {
        val matches : List<Match> = leagueParser.matches(matchesFDO)
        matches.forEach { it.leagueId = "test" }
        matchDAO.insertAll(matches)

        val exampleMatch = Match()
        exampleMatch.leagueId = "test"
        exampleMatch.matchDay = 38

        val searchResult = matchDAO.getByExample(exampleMatch)
        Assert.assertNotNull(searchResult)
        Assert.assertTrue(searchResult.size == matches.size)
        searchResult.forEach { matchDAO.delete(it.id!!) }
    }
}