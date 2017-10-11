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

@Component
@ManagedResource
open class DBService
{
    private val logger : Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var sportDataProvider : SportData

    @Autowired
    lateinit var leagueDAO : DAO<League>

    @Autowired
    lateinit var matchDAO : DAO<Match>

    fun hasDBConnection() : Boolean {
        return true
    }

    @ManagedOperation(description = "init database from footbal-data-org")
    fun initDB() {
        try {

            sportDataProvider.getAvailableLeagues().forEach {
                loadLeague(it)
                loadMatches(it)
            }
            logger.info("YEAH! DATABASE HAS SUCCESSFUL INIT")
        }
        catch (e : Exception)
        {
            logger.error("fail to load from api.", e)
        }
    }

    private fun loadLeague(leagueInfo: LeagueInfo) {
        logger.info("_______________ START LOAD LIAGUE ${leagueInfo.ShortName}")
        var league : League? = null
        var matchDay = 1
        while (matchDay <= leagueInfo.ToursPlayed) {
            league = getFilledLeague(sportDataProvider.getLeague(leagueInfo.Id, matchDay), leagueInfo)
            league.Teams.forEach { it.Players = getTeamPlayers(it.id!!) }
            leagueDAO.insert(league)
            logger.info("_______________ success load league ${leagueInfo.ShortName} matchday: $matchDay")
            matchDay++
        }
        logger.info("_______________ FINISH LOAD LIAGUE ${leagueInfo.ShortName}")
    }

    private fun getTeamPlayers(teamId: String) : Collection<Player> {
        return sportDataProvider.getTeamSquad(teamId.toInt())
    }

    private fun loadMatches(leagueInfo: LeagueInfo) {
        logger.info("_______________ START LOAD MATCHES FOR ${leagueInfo.ShortName}")
        var matchDay = 1
        while (matchDay <= leagueInfo.ToursPlayed) {
            val matches : Set<Match> = sportDataProvider.getMatches(leagueInfo.Id, matchDay)
            matchDAO.insertAll(matches)
            logger.info("_______________ success load matches for league ${leagueInfo.ShortName} matchday: $matchDay")
            matchDay++
        }
        logger.info("_______________ FINISH MATCHES FOR ${leagueInfo.ShortName}")
    }

    private fun getFilledLeague(league : League, leagueInfo: LeagueInfo) : League{
        return with(league) {
            ToursPlayed = leagueInfo.ToursPlayed
            ShortName = leagueInfo.ShortName
            Year = leagueInfo.Year
            this
        }
    }
}


