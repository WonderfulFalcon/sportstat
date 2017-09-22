package footballstat.database.dao.mongodb


import footballstat.model.football.Player
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
open class PlayersDAO : DefaultMongoRepository<Player>() {
    @Autowired
    lateinit var mongoRepository : PlayerMongoRepository

    override fun getMongoRepository(): MongoRepository<Player, String> {
        return mongoRepository
    }
}