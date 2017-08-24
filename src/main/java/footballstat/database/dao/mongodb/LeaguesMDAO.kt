package footballstat.database.dao.mongodb

import footballstat.model.football.League
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LeaguesMDAO : MongoRepository<League, String> {

}