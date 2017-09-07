package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import footballstat.model.football.League
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
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
        if (mongoLeague == null) { return null }
        val mongoTables : List<MongoTable> = mongoOperations.find(Query(Criteria.where("id").`in`(mongoLeague.TableIds)), MongoTable::class.java)
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
        var mongoLeague = mongoOperations.findOne(Query(Criteria.where("ShortName").`is`(obj.ShortName).andOperator(Criteria.where("Year"))), MongoLeague::class.java)

        val toSaveTable = with(MongoTable()) {
            this.MatchDay = obj.MatchDay
            this.Teams = obj.Teams
            this
        }

        if (mongoLeague == null)
        {
            mongoOperations.insert(toSaveTable)
            val toSaveLeague = with(MongoLeague()) {
                this.Name = obj.Name
                this.ShortName = obj.ShortName
                this.ToursPlayed = obj.ToursPlayed
                this.Year = obj.Year
                if (toSaveTable.id != null) {
                    this.TableIds.add(toSaveTable.id!!)
                }
                this
            }
            mongoOperations.insert(toSaveLeague)
        }
        else
        {
            val existingMongoTables = mongoOperations.find(Query.query(Criteria.where("id").`in`(mongoLeague.TableIds)), MongoTable::class.java)
            if (existingMongoTables.find { it.MatchDay == obj.MatchDay } == null) {
                mongoOperations.insert(toSaveTable)
                if (toSaveTable.id != null) {
                    mongoLeague.TableIds.add(toSaveTable.id!!)
                }
                mongoOperations.save(mongoLeague)
            }
        }
        return League()
    }

    override fun insertAll(listOfObj: Collection<League>) {
        listOfObj.forEach { it -> insert(it) }
    }

    override fun delete(id: String): Boolean {
        val searchLeagueQuery = Query(Criteria.where("id").`is`(id))

        val mongoLeague = mongoOperations.findOne(searchLeagueQuery, MongoLeague::class.java)
        val mongoTables = mongoOperations.find(Query.query(Criteria.where("id").`in`(mongoLeague.TableIds)), MongoTable::class.java)
        mongoTables.forEach { mongoOperations.remove(it.id) }
        mongoOperations.remove(it)
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

        var ToursPlayed : Int? = null
            get
            set

        var TableIds: ArrayList<String> = ArrayList()
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