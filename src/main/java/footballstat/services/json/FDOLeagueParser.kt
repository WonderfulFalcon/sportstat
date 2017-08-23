package footballstat.services.json

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.model.football.Table
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FDOLeagueParser : LeagueParser
{
    @Autowired
    private lateinit var tournamentParser : FDOTournamentTeamsParser

    private val mapper = ObjectMapper()

    override fun availableLeagues(json: String) : List<LeagueInfo>
    {
        return mapper.readTree(json).map {
            it ->  LeagueInfo(
                it.get("id").intValue,
                it.get("caption").textValue,
                it.get("currentMatchday").intValue,
                it.get("league").textValue)
        }
    }

    override fun matches(json: String): List<Match>
    {
        val fixtures = mapper.readTree(json).get("fixtures")
        return fixtures.map<JsonNode, Match> { match(it) }
    }

    override fun league(json: String) : League
    {
        val jsonNode = mapper.readTree(json)
        return with(League())
        {
            Name = jsonNode.get("leagueCaption")?.textValue
            MatchDay =  jsonNode.get("matchday").intValue

            Table = with(Table()) {
                Name = jsonNode.get("leagueCaption")?.textValue
                Teams = tournamentParser.getTeams(jsonNode.get("standing"))
                this
            }
            this
        }
    }

    private fun match(jsonNode: JsonNode) : Match
    {
        return with(Match()) {
            MatchDay = jsonNode.get("matchday").intValue
            HomeTeamName = jsonNode.get("homeTeamName")?.textValue
            AwayTeamName = jsonNode.get("awayTeamName")?.textValue
            GoalsHomeTeam = jsonNode.get("result").get("goalsHomeTeam")?.intValue
            GoalsAwayTeam = jsonNode.get("result").get("goalsAwayTeam")?.intValue
            this
        }
    }
}