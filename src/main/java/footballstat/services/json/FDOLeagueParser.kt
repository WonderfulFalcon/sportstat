package footballstat.services.json

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
import footballstat.model.football.Match
import footballstat.model.football.Table
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.node.ObjectNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FDOLeagueParser : LeagueParser
{
    @Autowired
    private lateinit var parserFactory : ParserFactory

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
        val parser = parserFactory.getParser(getLeagueType(jsonNode))

        if (type == League.LeagueType.TOURNAMENT)
        {
            val table = Table()
            table.Name = jsonNode.get("leagueCaption")?.textValue
            table.Teams = parser.getTeams(jsonNode.get("standing"))
            league.Tables.add(table)
        }
        else if (type == League.LeagueType.CUP)
        {
            val standings = jsonNode.get("standings") as ObjectNode
            val groups = standings.fieldNames

            for (group in groups)
            {
                val table = Table()
                table.Name = group
                table.Teams = parser.getTeams(standings.get(group))
                league.Tables.add(table)
            }
        }
        return league
    }

    private fun getLeagueType(jsonNode: JsonNode) : League.LeagueType
    {
        if (jsonNode.has("standing"))
        {
            return League.LeagueType.TOURNAMENT
        }
        else if (jsonNode.has("standings"))
        {
            return League.LeagueType.CUP
        }
        throw IllegalArgumentException("Cannot parse league type")
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