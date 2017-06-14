package footballstat.services.providers

import footballstat.config.business.FootballDataOrgConfig
import footballstat.model.football.Player
import footballstat.services.DataItems
import org.apache.http.client.fluent.Request
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.node.ArrayNode
import org.codehaus.jackson.node.IntNode
import org.codehaus.jackson.node.TextNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


class TeamsProvider
{
    @Component
    open class ExternalTeamsProvider : DataItems.Teams
    {
        @Autowired
        lateinit var config: FootballDataOrgConfig

        private val objectMapper = ObjectMapper()

        override fun getTeamSquad(teamId: Int): Collection<Player>
        {
            val url = with(config) { "${apiUrl}/${apiVersion}/${teams}/$teamId/${players}" }
            val request = Request.Get(url)
            request.addHeader("X-Auth-Token", config.xAuthToken)

            val response = request.execute().returnContent().asString()
            val jsonNode = objectMapper.readTree(response)

            val result = ArrayList<Player>()
            val elements = jsonNode.get("players")

            for (element in elements.elements)
            {
                result.add(player(element))
            }
            return result
        }

        private fun player(element: JsonNode): Player
        {
            return with(Player()) {
                Name = element.get("name")?.textValue
                Citizenships = element.get("nationality")?.textValue
                Number = element.get("jerseyNumber")?.intValue
                Position = element.get("jerseyNumber")?.textValue
                this
            }
        }
    }
}