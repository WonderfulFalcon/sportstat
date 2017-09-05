package footballstat.database.dao.mongodb

import footballstat.model.Country
import footballstat.model.football.Match
import footballstat.model.football.Team
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface CountryMongoRepository : MongoRepository<Country, String> { }

@Repository
interface MatchMongoRepository : MongoRepository<Match, String> { }

@Repository
interface TeamMongoRepository : MongoRepository<Team, String> { }