package footballstat.model.football

import java.util.*

class League
{
    var MatchDay : Int = 1
        get
        set

    var Name : String? = null
        get
        set

    var Year : Int? = null
        get
        set

    var Type : LeagueType = League.LeagueType.TOURNAMENT
        get
        set

    var Tables : ArrayList<Table> = ArrayList()
        get
        set

    enum class LeagueType
    {
        TOURNAMENT,
        CUP
    }
}