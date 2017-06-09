package footballstat.model.football

import footballstat.model.Country
import java.util.*

class Team(id : Int)
{
    var Id : Int = id
        get

    var Name : String? = null
        get
        set

    val Country : Country? = null
        get

    var Statistic : TournamentStatistic = TournamentStatistic()
        get
        set
}