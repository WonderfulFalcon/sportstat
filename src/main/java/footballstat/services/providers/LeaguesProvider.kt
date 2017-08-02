package footballstat.services.providers

import footballstat.config.business.FDOConfig
import footballstat.model.football.*
import footballstat.services.DataItems
import footballstat.services.json.LeagueParser
import footballstat.services.request.FDORequest
import footballstat.services.request.RequestProvider
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

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
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/?season=2016" } //HACK: FIX LATER

            return json.availableLeagues(request.getResponse(url)).filter {
                it -> config.availableLeagueIds.contains(it.Id)
            }
        }

        override fun getLeague(leagueId: Int, matchDay: Int) : League
        {
            val url = with(config) {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$leagueTable/?${config.matchDayFilter}=$matchDay"
            }
            return json.league(request.getResponse(url))
        }

        override fun getMatches(leagueId: Int, matchDay: Int): Set<Match>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/$leagueId/$matches/?$matchDayFilter=$matchDay" }
            return json.matches(request.getResponse(url)).toSet()
        }
    }
}