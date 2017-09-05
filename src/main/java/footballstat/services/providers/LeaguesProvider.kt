package footballstat.services.providers

import footballstat.config.business.FDOConfig
import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.services.DataItems
import footballstat.services.json.LeagueParser
import footballstat.services.request.RequestProvider
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

        override fun getLeague(leagueId: String, matchDay: Int) : League
        {
            val url = with(config) {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$leagueTable/?$matchDayFilter=$matchDay"
            }

            val league = json.league(request.getResponse(url));
            league.id = leagueId;

            return league;
        }

        override fun getMatches(leagueId: String, matchDay: Int): Set<Match>
        {
            val url = with(config) {
                "$apiUrl/$apiVersion/$competitions/$leagueId/$matches/?$matchDayFilter=$matchDay"
            }
            return json.matches(request.getResponse(url)).toSet()
        }
    }
}