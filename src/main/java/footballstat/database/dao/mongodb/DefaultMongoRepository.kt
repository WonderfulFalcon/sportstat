package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.MongoRepository

abstract class DefaultMongoRepository<T> : DAO<T> {

    override fun getAll(): Collection<T> {
        return getMongoRepository().findAll()
    }

    override fun getById(id: String): T? {
        return getMongoRepository().findOne(id)
    }

    override fun insert(obj: T): T? {
        getMongoRepository().insert(obj)
        return obj
    }

    override fun insertAll(listOfObj: Collection<T>) {
        listOfObj.forEach { obj -> insert(obj) }
    }

    override fun delete(id: String): Boolean {
        getMongoRepository().delete(id)
        return true
    }

    override fun getByExample(example: T): Iterable<T> {
        return getMongoRepository().findAll(Example.of(example))
    }

    abstract fun getMongoRepository() : MongoRepository<T, String>
}