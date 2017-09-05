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
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String): League? {
        val searchLeagueQuery = Query(Criteria.where("id").`is`(id))

        val mongoLeague = mongoOperations.findOne(searchLeagueQuery, MongoLeague::class.java)
        val mongoTables : List<MongoTable> = mongoOperations.find(Query(Criteria.where("id").`in`(mongoLeague.Tables)), MongoTable::class.java)
        val table : MongoTable = Collections.max(mongoTables, object : Comparator<MongoTable> {override fun compare(t1:MongoTable, t2:MongoTable) = t1.MatchDay - t2.MatchDay})
        return with(League()) {
            this.id = mongoLeague.id
            Name = mongoLeague.Name
            Year = mongoLeague.Year
            MatchDay = table.MatchDay
            Teams = table.Teams
            this
        }
    }

    override fun insert(obj: League): League? {
        return League()
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

        var ToursPlayed : String? = null
            get
            set

        var Tables : ArrayList<String> = ArrayList()
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