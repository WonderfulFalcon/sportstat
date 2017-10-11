package footballstat.database.dao.mongodb


import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
open class TeamDAO : DefaultMongoRepository<Team>() {
    @Autowired
    lateinit var mongoRepository : TeamMongoRepository

    override fun getMongoRepository(): MongoRepository<Team, String> {
        return mongoRepository
    }


}