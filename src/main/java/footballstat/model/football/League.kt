package footballstat.model.football

class League
{
    var id : String? = null
        get
        set

    var IdFromApi : Int? = null
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

    var Table: Table = Table()
        get
        set

    var ShortName : String? = null
        get
        set
}