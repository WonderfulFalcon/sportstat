package footballstat.model.football

import java.time.LocalDateTime

class Match(id : Int)
{
    val Id : Int = id
        get

    var Date : LocalDateTime? = null
        get
        set

    var leagueId : Int? = null
        get
        set

    var MatchDay : Int = 0
        get
        set

    var HomeTeam : Team? = null
        get
        set

    var AwayTeam : Team? = null
        get
        set

    var Result : MatchResult? = null
        get
        set
}