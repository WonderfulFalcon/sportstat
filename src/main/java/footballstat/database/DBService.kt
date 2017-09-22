package footballstat.database


import footballstat.database.dao.DAO
import footballstat.model.football.*
import footballstat.services.SportData
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component
import java.util.*

@Component
@ManagedResource
open class DBService
{
    @Autowired
    lateinit var sportDataProvider : SportData

    @Autowired
    lateinit var leagueDAO : DAO<League>

    @Autowired
    lateinit var matchDAO : DAO<Match>

    @Autowired
    lateinit var playersDAO : DAO<Player>

    fun hasDBConnection() : Boolean {
        return true
    }

    @ManagedOperation
    fun initDB() {
        sportDataProvider.getAvailableLeagues().forEach {
            loadLeague(it)
            //loadMatches(it)
        }
    }

    private fun loadLeague(leagueInfo: LeagueInfo) {
        var league : League? = null
        var matchDay = 0
        while (matchDay <= leagueInfo.ToursPlayed) {
            league= getFilledLeague(sportDataProvider.getLeague(leagueInfo.Id, matchDay), leagueInfo)
            leagueDAO.insert(league)
            matchDay++
        }
        //loadTeamPlayers(league!!.Teams)
    }

    private fun loadTeamPlayers(teams: ArrayList<Team>) {

    }

    private fun loadMatches(leagueInfo: LeagueInfo) {
        var matchDay = 0
        while (matchDay <= leagueInfo.ToursPlayed) {
            val matches : Set<Match> = sportDataProvider.getMatches(leagueInfo.Id, matchDay)
            matchDAO.insertAll(matches)
            matchDay++
        }
    }

    private fun getFilledLeague(league : League, leagueInfo: LeagueInfo) : League{
        return with(league) {
            ToursPlayed = leagueInfo.ToursPlayed
            ShortName = leagueInfo.ShortName
            this
        }
    }
}


