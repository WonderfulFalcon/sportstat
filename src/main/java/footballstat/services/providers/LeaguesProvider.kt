package footballstat.services.providers

import footballstat.config.business.FootballDataOrgConfig
import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Team
import footballstat.model.football.TournamentStatistic
import footballstat.services.DataItems
import org.apache.http.client.fluent.Request
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.node.ArrayNode
import org.codehaus.jackson.node.IntNode
import org.codehaus.jackson.node.TextNode
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

        override fun getAvailableLeagues(): List<LeagueInfo>
        {
            val url = with(config) { "$apiUrl/$apiVersion/$competitions" }
            val request = Request.Get(url)
            request.addHeader("X-Auth-Token", config.xAuthToken)

            val response = request.execute().returnContent().asString()
            val jsonNode = objectMapper.readTree(response) as ArrayNode

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

            val request = Request.Get(url)
            request.addHeader("X-Auth-Token", config.xAuthToken)

            val response = request.execute().returnContent().asString()
            return parseLeague(response)
        }

        private fun parseLeague(response: String): League
        {
            val jsonNode = objectMapper.readTree(response)
            val league = league(jsonNode)

            val standings = jsonNode.get("standing") as ArrayNode
            for (element in standings.elements) {
                val urlArray = (element.get("_links").get("team").get("href") as? TextNode)?.textValue?.split('/')
                val id = if (urlArray != null) urlArray[urlArray.size - 1].toInt() else null

                if (id != null)
                {
                    val team = Team(id)

                    team.Name = (element.get("teamName") as TextNode).textValue
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
                Name = (jsonNode.get("leagueCaption") as TextNode).textValue
                MatchDay =  (jsonNode.get("matchday") as IntNode).intValue
                this
            }
        }

        private fun tournamentStatistic(element: JsonNode): TournamentStatistic
        {
            return with(TournamentStatistic())
            {
                PlayedGames = (element.get("playedGames") as IntNode).intValue
                Position = (element.get("position") as IntNode).intValue
                Points = (element.get("points") as IntNode).intValue
                GoalsScored = (element.get("goals") as IntNode).intValue
                GoalsAgainst = (element.get("goalsAgainst") as IntNode).intValue
                GoalsDifference = (element.get("goalDifference") as IntNode).intValue
                Wins = (element.get("wins") as IntNode).intValue
                Draws = (element.get("draws") as IntNode).intValue
                Losses = (element.get("losses") as IntNode).intValue
                this
            }
        }
    }
}