package footballstat.database.dao.mongodb

import footballstat.model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
open class CountryDAO : DefaultMongoRepository<Country>() {
    @Autowired
    lateinit var mongoRepository : CountryMongoRepository

    override fun getMongoRepository(): MongoRepository<Country, String> {
        return mongoRepository
    }
}