package footballstat.model.football

import footballstat.model.Country
import java.util.*

class Team(name : String)
{
    val Name : String = name
        get

    val Country : Country? = null
        get

    var LineUp : Collection<Player> = ArrayList()
        get
        set
}