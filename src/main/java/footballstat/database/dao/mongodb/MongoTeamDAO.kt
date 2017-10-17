package footballstat.database.dao.mongodb


import footballstat.database.dao.entity.MongoTeam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
open class MongoTeamDAO : DefaultMongoRepository<MongoTeam>() {
    @Autowired
    lateinit var mongoRepository : TeamMongoMongoRepository

    override fun getMongoRepository(): MongoRepository<MongoTeam, String> {
        return mongoRepository
    }

    override fun insert(obj: MongoTeam) : MongoTeam? {
        try {
            super.insert(obj)
        }
        catch (e : DuplicateKeyException) {
        }
        return obj
    }
}