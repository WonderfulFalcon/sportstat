package footballstat.database

import footballstat.services.SportData
import org.codehaus.jackson.map.SerializationConfig
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(locations= arrayOf("classpath:config/testdata/test-values.properties"))
class GetLeaguesMatchesTest {
    @Autowired
    lateinit var sportData : SportData

    @Value("\${GetLeaguesMatchesTest.expect}")
    private val expect: String = ""

    private var objectMapper : org.codehaus.jackson.map.ObjectMapper = org.codehaus.jackson.map.ObjectMapper()

    @Test
    fun getLeaguesMatchesTest()
    {
        objectMapper.configure(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY, true);
        Assert.assertEquals(expect, objectMapper.writeValueAsString(sportData.getLeagueLastMatchesByTeams("426", 5)))
    }
}