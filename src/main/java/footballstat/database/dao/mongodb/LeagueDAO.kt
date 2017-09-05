package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import footballstat.model.football.League
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Service

@Service
class LeagueDAO : DAO<League> {

    @Autowired
    lateinit var mongoOperations : MongoOperations

    override fun getAll(): Collection<League> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String): League? {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(obj: League): League? {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertAll(listOfObj: Collection<League>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: String): Boolean {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}