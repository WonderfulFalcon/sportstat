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


/**
 * TODO 1. ОБЯЗАТЕЛЬНО ВЫПОЛНИТЬ ВСЕ ПРОВЕРКИ НА ВАЛИДНОСТЬ ДАННЫХ И ТИПОВ ДАННЫХ ?!!
 * TODO 2. придумать как избавиться от сайд-эффекта методов этой DAO - сохранение league вызывает сохранение table, удаление league вызовает удаление table
 */
@Service
class LeagueDAO : DAO<League> {

    @Autowired
    lateinit var mongoOperations : MongoOperations

    @Autowired
    lateinit var teamDAO : DAO<Team>

    override fun getAll(): Collection<League> {
        return mongoOperations.findAll(MongoLeague::class.java).map{ with(League())  {
            this.id = it.id
            Name = it.name
            ShortName = it.shortName
            Year = it.year
            ToursPlayed = it.toursPlayed
            this
        } }
    }

    override fun getById(id: String): League? {
        val searchLeagueQuery = Query(Criteria.where("id").`is`(id))

        val mongoLeague = mongoOperations.findOne(searchLeagueQuery, MongoLeague::class.java)

        return mongoLeague?.let { convertToLeague(mongoLeague, null)}
    }

    override fun insert(obj: League): League? {
        with(obj) {
            val isValidObject = ShortName != null && Year != null && ToursPlayed != null && Name != null
            if (!isValidObject) return null
        }

        var mongoLeague : MongoLeague? = mongoOperations.findOne(Query(Criteria.where("shortName").`is`(obj.ShortName).andOperator(Criteria.where("year").`is`(obj.Year))), MongoLeague::class.java)

        teamDAO.insertAll(obj.Teams)

        val toSaveTable = with(MongoTable()) {
            this.matchDay = obj.MatchDay
            this.teams = obj.Teams.map { it.id!! }
            this
        }

        if (mongoLeague == null)
        {
            mongoOperations.insert(toSaveTable)
            val toSaveLeague = with(MongoLeague()) {
                this.name = obj.Name
                this.shortName = obj.ShortName
                this.toursPlayed = obj.ToursPlayed
                this.year = obj.Year
                if (toSaveTable.id != null) {
                    this.tableIds.add(toSaveTable.id!!)
                }
                this
            }
            mongoLeague = toSaveLeague;
            mongoOperations.insert(toSaveLeague)
        }
        else
        {
            val existingMongoTables = mongoOperations.find(Query.query(Criteria.where("id").`in`(mongoLeague.tableIds)), MongoTable::class.java)
            if (existingMongoTables.find { it.matchDay == obj.MatchDay } == null) {
                mongoOperations.insert(toSaveTable)
                if (toSaveTable.id != null) {
                    mongoLeague.tableIds.add(toSaveTable.id!!)
                }
                mongoOperations.save(mongoLeague)
            }
        }
        return with(obj) { this.id = mongoLeague!!.id; this;}
    }

    override fun insertAll(listOfObj: Collection<League>) {
        listOfObj.forEach { it -> insert(it) }
    }

    override fun delete(id: String): Boolean {
        val searchLeagueQuery = Query(Criteria.where("id").`is`(id))

        val mongoLeague = mongoOperations.findOne(searchLeagueQuery, MongoLeague::class.java)
        mongoOperations.remove(Query.query(Criteria.where("id").`in`(mongoLeague.tableIds)), MongoTable::class.java)
        mongoOperations.remove(mongoLeague)
        return true
    }

    override fun getByExample(example: League): Collection<League> {
        val searchLeagueQuery = Query()
        with(example) {
            id?.let { searchLeagueQuery.addCriteria( Criteria.where("id").`is`(it) ) }
            ShortName?.let { searchLeagueQuery.addCriteria(Criteria.where("ShortName").`is`(it) ) }
            Year?.let { searchLeagueQuery.addCriteria(Criteria.where("Year").`is`(it) ) }
            Name?.let { searchLeagueQuery.addCriteria(Criteria.where("Name").`is`(it) ) }
        }
        val mongoLeagues : Iterable<MongoLeague> = mongoOperations.find(searchLeagueQuery, MongoLeague::class.java)
        return mongoLeagues.map { convertToLeague(it, example.MatchDay) }
    }

    private fun convertToLeague(mongoLeague : MongoLeague, idMatchDay : Int?) : League {
        val mongoTables : List<MongoTable> = mongoOperations.find(Query(Criteria.where("id").`in`(mongoLeague.tableIds)), MongoTable::class.java)
        var table : MongoTable? = null
        if (idMatchDay == null) {
            table = Collections.max(mongoTables) { t1, t2 -> t1.matchDay - t2.matchDay }
        }
        else {
            table = mongoTables.filter { it.matchDay == idMatchDay }.first()
        }
        return with(League()) {
            this.id = mongoLeague.id
            Name = mongoLeague.name
            Year = mongoLeague.year
            ShortName = mongoLeague.shortName
            ToursPlayed = mongoLeague.toursPlayed
            MatchDay = table!!.matchDay
            Teams = table!!.teams.map { teamDAO.getById(it)!! }
            this
        }
    }

    open class MongoLeague {
        var id: String? = null
            get
            set

        var name: String? = null
            get
            set

        var year: Int? = null
            get
            set

        var shortName: String? = null
            get
            set

        var toursPlayed: Int? = null
            get
            set

        var tableIds: ArrayList<String> = ArrayList()
            get
            set
    }

    open class MongoTable {
        var id: String? = null
            get
            set

        var matchDay: Int = 1
            get
            set

        var teams: List<String> = ArrayList()
            get
            set
    }
}