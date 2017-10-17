package footballstat.database.dao.entity

import footballstat.model.football.Team

open class MongoLeague {
    var id: String? = null
        get
        set

    var iD: String? = null
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

    var matchday: Int? = null
        get
        set

    var teams: List<Team>? = null
        get
        set
}