package footballstat.model.football

import java.util.*

class League
{
    var id: String? = null
        get
        set

    var MatchDay : Int = 1
        get
        set

    var Name : String? = null
        get
        set

    var Year : Int? = null
        get
        set

    var ToursPlayed : Int? = null
        get
        set

    var ShortName : String? = null
        get
        set

    var Teams: List<Team> = ArrayList()
        get
        set
}