package footballstat.services.providers

import footballstat.config.business.FootballDataOrgConfig
import footballstat.model.football.Player
import footballstat.services.DataItems
import org.apache.http.client.fluent.Request
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
            val elements = jsonNode.get("players") as? ArrayNode
            for (element in elements!!.elements)
            {
                val player = Player()
                player.Name = (element.get("name") as? TextNode)?.textValue

                val nationality = (element.get("nationality") as? TextNode)?.textValue

                if (nationality != null)
                {
                    player.Citizenships.add(nationality)
                }

                player.Number = (element.get("jerseyNumber") as? IntNode)?.intValue
                player.Position = (element.get("jerseyNumber") as? TextNode)?.textValue

                result.add(player)
            }

            return result
        }
    }
}