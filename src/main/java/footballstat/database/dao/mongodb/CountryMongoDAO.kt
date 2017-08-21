package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import footballstat.database.entity.CountryEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Service
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.Criteria.*

@Service
open class CountryMongoDAO : DAO<CountryEntity> {
    @Autowired
    lateinit var operations : MongoOperations

    override fun findAll(): Collection<CountryEntity> {
        return operations.findAll(CountryEntity::class.java)
    }

    override fun findOne(id: Int): CountryEntity? {
        return operations.findOne(query(where("Id").`is`(id)), CountryEntity::class.java)
    }

    override fun insert(obj: CountryEntity): CountryEntity? {
        operations.insert(obj)
        return obj
    }

    override fun insertAll(listOfObj: Collection<CountryEntity>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(id: Int): Boolean {
        return operations.remove(query(where("Id").`is`(id)), CountryEntity::class.java).isUpdateOfExisting
    }
}