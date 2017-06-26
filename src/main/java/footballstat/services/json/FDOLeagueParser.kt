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
    private lateinit var teamsParser : FDOTeamsParser

    private val mapper = ObjectMapper()

    override fun availableLeagues(json: String) : List<LeagueInfo>
    {
        return mapper.readTree(json).map {
            it ->  LeagueInfo(
                it.get("id").intValue,
                it.get("caption").textValue,
                it.get("currentMatchday").intValue)
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
        val league = with(League()) {
            Name = jsonNode.get("leagueCaption")?.textValue
            MatchDay =  jsonNode.get("matchday").intValue
            this
        }

        val type = getLeagueType(jsonNode)

        if (type == League.LeagueType.TOURNAMENT)
        {
            val table = Table()
            table.Name = jsonNode.get("leagueCaption")?.textValue
            table.Teams = teamsParser.getTeams(jsonNode.get("standing"), type)
            league.Tables.add(table)
        }
        else if (type == League.LeagueType.CUP)
        {
            val standings = jsonNode.get("standings")
            for (standing in standings)
            {
                val table = Table()
                table.Name = standing.get("group")?.textValue
                table.Teams = teamsParser.getTeams(standing, type)
                league.Tables.add(table)
            }
        }
        return league
    }

    private fun getLeagueType(jsonNode: JsonNode) : League.LeagueType?
    {
        if (jsonNode.has("standing"))
        {
            return League.LeagueType.TOURNAMENT
        }
        else if (jsonNode.has("standings"))
        {
            return League.LeagueType.CUP
        }
        return null
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