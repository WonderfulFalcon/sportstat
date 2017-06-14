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

    var Teams : ArrayList<Team> = ArrayList()
        get
        set
}