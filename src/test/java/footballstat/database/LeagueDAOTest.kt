package footballstat.database


import footballstat.database.dao.DAO
import footballstat.model.football.League
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
open class LeagueDAOTest {
    @Autowired
    lateinit var leagueDao : DAO<League>

    @Test
    open fun Tst()
    {
        Assert.assertTrue(10 == 10)
    }
}