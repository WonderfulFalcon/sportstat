package footballstat.model.football

import java.util.*

class Player()
{
    var Name : String? = null
        get
        set

    var Citizenships : MutableSet<String> = HashSet()
        get
        set

    var Age : Int? = null
        get
        set

    var Number : Int? = null
        get
        set

    var Position : String? = null
        get
        set
}