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

        private val objectMapper = ObjectMapper()

        override fun getAvailableLeagues(): List<LeagueInfo>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/?season=2016" } //HACK: FIX LATER
            val jsonNode = objectMapper.readTree(request.getResponse(url))

            return json.availableLeagues(jsonNode).filter {
                it -> !config.forbiddenLeagueIds.contains(it.Id)
            }
        }

        override fun getLeague(leagueId: Int, matchDay: Int) : League
        {
            val url = with(config) {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$leagueTable/?${config.matchDayFilter}=$matchDay"
            }
            return json.league(objectMapper.readTree(request.getResponse(url)))
        }

        override fun getMatches(leagueId: Int, matchDay: Int): Set<Match>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/$leagueId/$matches/?$matchDayFilter=$matchDay" }
            val fixtures = objectMapper.readTree(request.getResponse(url)).get("fixtures")
            return fixtures.map<JsonNode, Match> { json.match(it) }.toSet()
        }
    }
}