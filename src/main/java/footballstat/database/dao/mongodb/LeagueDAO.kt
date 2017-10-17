package footballstat.database.dao.mongodb

import footballstat.database.dao.DAO
import footballstat.database.dao.entity.MongoLeague
import footballstat.model.Country
import footballstat.model.football.League
import footballstat.model.football.Player
import footballstat.model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.session.SessionProperties
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*


/**
 * TODO Удалить и написать заново
 */
@Service
open class LeagueDAO : DAO<League> {


    @Autowired
    lateinit var leagueMongoRepository : LeagueMongoRepository

    override fun getAll(): Collection<League> {
        return getByExample(with(League()) {
            this.id = id
            this.MatchDay = 1
            this
        })
    }

    override fun getById(id: String): League? {
        val result : Collection<League> = getAll()
        if(result.isEmpty())
        {
            return null
        }
        return result.first()
    }

    override fun insert(obj: League): League? {
        val mongoLeague : MongoLeague = with(MongoLeague()) {
            iD = obj.id
            name = obj.Name
            year = obj.Year
            shortName = obj.ShortName
            toursPlayed = obj.ToursPlayed
            matchday = obj.MatchDay
            teams = obj.Teams
            this
        }
        leagueMongoRepository.insert(mongoLeague)

        return obj
    }

    override fun insertAll(listOfObj: Collection<League>) {
        listOfObj.forEach {
            insert(it)
        }
    }

    override fun delete(id: String): Boolean {
        val league : League = with(League()) {
            this.id = id
            this
        }
        leagueMongoRepository.delete(getMongoLeagueByExample(league))

        return true;
    }

    override fun getByExample(example: League): Collection<League> {
       return getMongoLeagueByExample(example).map() { convertMongoLeagueToLeague(it) }
    }

    private fun convertMongoLeagueToLeague(mongoLeague : MongoLeague) : League
    {
        return with(League()) {
            id = mongoLeague.iD
            Name = mongoLeague.name
            Year = mongoLeague.year
            ShortName = mongoLeague.shortName
            MatchDay = mongoLeague.matchday
            ToursPlayed = mongoLeague.toursPlayed
            Teams = mongoLeague.teams
            this
        }
    }

    fun getMongoLeagueByExample(example: League): Collection<MongoLeague> {
        val mongoLeague : MongoLeague = with(MongoLeague()) {
            iD = example.id
            name = example.Name
            year = example.Year
            shortName = example.ShortName
            toursPlayed = example.ToursPlayed
            matchday = example.MatchDay
            this
        }

        return leagueMongoRepository.findAll(Example.of(mongoLeague))
    }
}