package footballstat.services.providers

import footballstat.config.business.FDOConfig
import footballstat.database.dao.mongodb.MongoTeamDAO
import footballstat.model.football.Player
import footballstat.services.DataItems
import footballstat.services.request.FDORequest
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


class TeamsProvider
{
    @Component
    open class ExternalTeamsProvider : DataItems.Teams
    {
        @Autowired
        private lateinit var config: FDOConfig

        @Autowired
        private lateinit var request : FDORequest

        private val objectMapper = ObjectMapper()

        override fun getTeamSquad(teamId: Int): Collection<Player>
        {
            val url = with(config) { "${apiUrl}/${apiVersion}/${teams}/$teamId/${players}" }
            val jsonNode = objectMapper.readTree(request.getResponse(url))

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
                Country = element.get("nationality")?.textValue
                Number = element.get("jerseyNumber")?.intValue
                Position = element.get("position")?.textValue
                this
            }
        }
    }

    @Component
    open class InternalTeamProvider : DataItems.Teams
    {
        @Autowired
        lateinit var teamSquadDAO : MongoTeamDAO

        override fun getTeamSquad(teamId: Int): Collection<Player>
        {
            return teamSquadDAO.getById(teamId.toString())?.Players!!
        }

    }
}