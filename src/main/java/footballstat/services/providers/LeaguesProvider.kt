package footballstat.services.providers

import footballstat.config.business.FootballDataOrgConfig
import footballstat.model.football.*
import footballstat.services.DataItems
import org.apache.http.client.fluent.Request
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
        lateinit var config: FootballDataOrgConfig

        private val objectMapper = ObjectMapper()

        private fun getResponse(requestUrl : String) : String
        {
            val request = Request.Get(requestUrl)
            request.addHeader("X-Auth-Token", config.xAuthToken)
            return request.execute().returnContent().asString()
        }

        override fun getAvailableLeagues(): List<LeagueInfo>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions" }
            val jsonNode = objectMapper.readTree(getResponse(url))

            return jsonNode.map {
                it ->  LeagueInfo(
                    it.get("id").intValue,
                    it.get("caption").textValue,
                    it.get("currentMatchday").intValue)
            }.filter {
                it -> !config.forbiddenLeagueIds.contains(it.Id)
            }
        }

        override fun getLeague(leagueId: Int, matchDay: Int?) : League
        {
            var url = with(config) { "$apiUrl/$apiVersion/$competitions/$leagueId/$leagueTable" }

            if (matchDay != null)
            {
                url = "$url/?${config.matchDayFilter}=$matchDay"
            }
            return parseLeague(getResponse(url))
        }

        override fun getMatches(leagueId: Int, matchDay: Int): Set<Match>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions/$leagueId/$matches/?$matchDayFilter=$matchDay" }
            val fixtures = objectMapper.readTree(getResponse(url)).get("fixtures")
            return fixtures.map<JsonNode, Match> { parseMatch(leagueId, it) }.toSet()
        }

        private fun parseMatch(leagueId: Int, it: JsonNode): Match
        {
            return with(Match()) {
                LeagueId = leagueId
                MatchDay = it.get("matchday").intValue
                HomeTeamName = it.get("homeTeamName")?.textValue
                AwayTeamName = it.get("awayTeamName")?.textValue
                GoalsHomeTeam = it.get("result").get("goalsHomeTeam")?.intValue
                GoalsAwayTeam = it.get("result").get("goalsAwayTeam")?.intValue
                this
            }
        }

        private fun parseLeague(response: String): League
        {
            val jsonNode = objectMapper.readTree(response)
            val league = league(jsonNode)

            val standings = jsonNode.get("standing")
            for (element in standings.elements) {
                val urlArray = (element.get("_links").get("team").get("href")).textValue?.split('/')
                val id = if (urlArray != null) urlArray[urlArray.size - 1].toInt() else null

                if (id != null)
                {
                    val team = Team(id)

                    team.Name = element.get("teamName")?.textValue
                    team.Statistic = tournamentStatistic(element)
                    league.Teams.add(team)
                }
            }
            return league
        }

        private fun league(jsonNode: JsonNode): League
        {
            return with(League())
            {
                Name = jsonNode.get("leagueCaption")?.textValue
                MatchDay =  jsonNode.get("matchday").intValue
                this
            }
        }

        private fun tournamentStatistic(element: JsonNode): TournamentStatistic
        {
            return with(TournamentStatistic())
            {
                PlayedGames = element.get("playedGames").intValue
                Position = element.get("position").intValue
                Points = element.get("points").intValue
                GoalsScored = element.get("goals").intValue
                GoalsAgainst = element.get("goalsAgainst").intValue
                GoalsDifference = element.get("goalDifference").intValue
                Wins = element.get("wins").intValue
                Draws = element.get("draws").intValue
                Losses = element.get("losses").intValue
                this
            }
        }
    }
}