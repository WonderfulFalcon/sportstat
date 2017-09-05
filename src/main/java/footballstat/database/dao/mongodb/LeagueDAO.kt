package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import footballstat.model.football.League
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.util.*

@Service
class LeagueDAO : DAO<League> {

    @Autowired
    lateinit var mongoOperations : MongoOperations

    @Autowired
    lateinit var teamDAO : TeamDAO

    override fun getAll(): Collection<League> {
        return mongoOperations.findAll(League::class.java)
    }

    override fun getById(id: String): League? {
        val searchLeagueQuery = Query(Criteria.where("id").`is`(id))
        return mongoOperations.findOne(searchLeagueQuery, League::class.java)
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


    class MongoLeague {
        var id: String? = null
            get
            set

        var Name : String? = null
            get
            set

        var Year : Int? = null
            get
            set

        var ShortName : String? = null
            get
            set

        var Tables : ArrayList<MongoTable> = ArrayList()
            get
            set
    }

    class MongoTable {
        var id: String? = null
            get
            set

        var MatchDay : Int = 1
            get
            set

        var Teams : ArrayList<Team> = ArrayList()
            get
            set
    }
}