package footballstat.services.providers

import footballstat.config.business.ExternalProviderConfig
import footballstat.model.football.League
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
        lateinit var externalConfig: ExternalProviderConfig

        private val objectMapper = ObjectMapper()

        override fun getCurrentLeague(leagueId: Int): League
        {
            val response = Request.Get("${externalConfig.competitionUrl}/$leagueId/${externalConfig.leagueSuffix}/").execute().returnContent().asString()
            return parseLeague(response)
        }

        override fun getLeague(leagueId: Int, year: Int) : League
        {
            //TODO: add here filter at year
            val response = Request.Get("${externalConfig.competitionUrl}/$leagueId/${externalConfig.leagueSuffix}/").execute().returnContent().asString()
            return parseLeague(response)
        }

        private fun parseLeague(response: String): League
        {
            val jsonNode = objectMapper.readTree(response)
            val league = league(jsonNode)

            val standings = jsonNode.get("standing") as? ArrayNode
            for (element in standings!!.elements) {
                val team = Team()

                team.Name = (element.get("teamName") as? TextNode)?.textValue
                team.Statistic = tournamentStatistic(element)

                league.Teams.add(team)
            }
            return league
        }

        private fun league(jsonNode: JsonNode): League
        {
            return with(League())
            {
                Name = (jsonNode.get("leagueCaption") as? TextNode)?.textValue
                MatchDay = (jsonNode.get("matchday") as? IntNode)?.intValue
                this
            }
        }

        private fun tournamentStatistic(element: JsonNode): TournamentStatistic
        {
            return with(TournamentStatistic())
            {
                PlayedGames = (element.get("playedGames") as? IntNode)?.intValue
                Position = (element.get("position") as? IntNode)?.intValue
                Points = (element.get("points") as? IntNode)?.intValue
                GoalsScored = (element.get("goals") as? IntNode)?.intValue
                GoalsAgainst = (element.get("goalsAgainst") as? IntNode)?.intValue
                GoalsDifference = (element.get("goalDifference") as? IntNode)?.intValue
                Wins = (element.get("wins") as? IntNode)?.intValue
                Draws = (element.get("draws") as? IntNode)?.intValue
                Losses = (element.get("losses") as? IntNode)?.intValue
                this
            }
        }
    }
}