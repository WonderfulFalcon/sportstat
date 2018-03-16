package footballstat.services.providers

import footballstat.config.business.FDOConfig
import footballstat.database.dao.DAO
import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.services.DataItems
import footballstat.services.json.LeagueParser
import footballstat.services.request.RequestProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import java.util.*

class LeaguesProvider
{
    @Component
    open class ExternalLeaguesProvider : DataItems.Leagues
    {
        @Autowired
        lateinit var config : FDOConfig

        @Autowired
        lateinit var request : RequestProvider

        @Autowired
        lateinit var json : LeagueParser

        override fun getAvailableLeagues(): List<LeagueInfo>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/?season=$defaultSeason" }

            return json.availableLeagues(request.getResponse(url)).filter {
                it -> config.availableLeagueIds.contains(it.Id)
            }
        }

        override fun getLeague(leagueId: String, matchDay: Int) : League
        {
            val url = with(config)
            {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$leagueTable/?$matchDayFilter=$matchDay"
            }

            val league = json.league(request.getResponse(url));
            league.id = leagueId;

            return league;
        }

        override fun getMatches(leagueId: String, matchDay: Int): Set<Match>
        {
            val url = with(config)
            {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$matches/?$matchDayFilter=$matchDay"
            }
            return json.matches(request.getResponse(url)).toSet()
        }

        override fun getMatches(leagueId: String): Set<Match> {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    @Component
    open class InternalLeaguesProvider : DataItems.Leagues
    {
        @Autowired
        lateinit var leagueDAO : DAO<League>

        @Autowired
        lateinit var matchDAO : DAO<Match>

        @Cacheable(cacheNames = arrayOf("availableLeagues"))
        override fun getAvailableLeagues(): List<LeagueInfo>
        {
            //Здесь потенциальная БАГА - что, если у лиги нет MatchDay = 1 ??? Глупо, странно, но вдруг
            val leagues = leagueDAO.getByExample(
                    with(League())
                    {
                        this.MatchDay = 1
                        this
                    }
            )
            return leagues.map {
                LeagueInfo(it.id!!, it.Name!!, it.ToursPlayed!!, it.ShortName!!, it.Year!!)
            }
        }

        @Cacheable(cacheNames = arrayOf("leagues"))
        override fun getLeague(leagueId: String, matchDay: Int): League
        {
            return leagueDAO.getByExample(
                    with(League())
                    {
                        this.id = leagueId
                        this.MatchDay = matchDay
                        this
                    }
            ).first()
        }

        @Cacheable(cacheNames = arrayOf("tourMatches"))
        override fun getMatches(leagueId: String, matchDay: Int): Set<Match> {
            return HashSet(matchDAO.getByExample(
                    with(Match())
                    {
                        this.leagueId = leagueId
                        this.matchDay = matchDay
                        this
                    }
            ))
        }

        @Cacheable(cacheNames = arrayOf("allMatches"))
        override fun getMatches(leagueId: String): Set<Match> {
            return HashSet(matchDAO.getByExample(
                    with(Match())
                    {
                        this.leagueId = leagueId
                        this
                    }
            ))
        }
    }
}