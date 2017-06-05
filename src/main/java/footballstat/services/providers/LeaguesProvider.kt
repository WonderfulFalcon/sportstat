package footballstat.services.providers

import footballstat.model.football.Team
import footballstat.model.football.TournamentStatistic
import footballstat.services.DataItems
import footballstat.services.ExternalProvider
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.node.ArrayNode
import org.codehaus.jackson.node.IntNode
import org.codehaus.jackson.node.TextNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

class LeaguesProvider
{
    @Component
    open class ExternalLeaguesProvider : DataItems.Leagues
    {
        @Autowired
        lateinit var externalProvider : ExternalProvider

        override fun getLeague(leagueId: Int, year: Int): Collection<Team>
        {
            val response = externalProvider.getResponse("http://api.football-data.org/v1/competitions/426/leagueTable")
            val mapper = ObjectMapper()

            val standings = mapper.readTree(response).get("standing") as? ArrayNode
            val league = ArrayList<Team>()

            for (element in standings!!.elements)
            {
                val team = Team()

                team.Name = (element.get("teamName") as? TextNode)?.textValue
                team.Statistic = tournamentStatistic(element)

                league.add(team)
            }
            return league
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