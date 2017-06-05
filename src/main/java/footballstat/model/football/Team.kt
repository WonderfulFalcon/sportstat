package footballstat.model.football

import footballstat.model.Country
import java.util.*

class Team()
{
    var Name : String? = null
        get
        set

    val Country : Country? = null
        get

    var LineUp : Collection<Player> = ArrayList()
        get
        set

    var Statistic : TournamentStatistic? = null
        get
        set
}