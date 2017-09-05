package footballstat.database.dao.mongodb


import footballstat.model.football.Match
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
open class MatchDAO : DefaultMongoRepository<Match>() {
    @Autowired
    lateinit var mongoRepository : MatchMongoRepository

    override fun getMongoRepository(): MongoRepository<Match, String> {
        return mongoRepository
    }
}