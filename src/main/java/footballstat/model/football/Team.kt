package footballstat.model.football

import footballstat.model.Country
import java.util.*

class Team(name : String, country: Country)
{
    val Name : String = name
        get

    val Country : Country = country
        get

    var LineUp : Collection<Player> = ArrayList()
        get
        set
}