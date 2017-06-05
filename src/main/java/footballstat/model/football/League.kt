package footballstat.model.football

import java.util.*

class League
{
    var Name : String? = null
        get
        set

    var MatchDay : Int? = null
        get
        set

    var Year : Int? = null
        get
        set

    var Teams : ArrayList<Team> = ArrayList()
        get
        set
}