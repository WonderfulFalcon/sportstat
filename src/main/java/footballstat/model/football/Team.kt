package footballstat.model.football

import footballstat.model.Country

class Team(id : Int)
{
    var Id : Int = id
        get

    var Name : String? = null
        get
        set

    val Country : Country? = null
        get

    var AllStatistic : TournamentStatistic = TournamentStatistic()
        get
        set

    var HomeStatistic : TournamentStatistic = TournamentStatistic()
        get
        set

    var AwayStatistic : TournamentStatistic = TournamentStatistic()
        get
        set
}