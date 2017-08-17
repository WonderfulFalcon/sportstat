package footballstat.model.football

class TournamentStatistic
{
    var Position : Int = -1
        get
        set

    var PlayedGames : Int = 0
        get
        set

    var Points : Int = 0
        get
        set

    var GoalsScored : Int = 0
        get
        set

    var GoalsAgainst : Int = 0
        get
        set

    var GoalsDifference : Int = 0
        get
        set

    var Wins : Int = 0
        get
        set

    var Draws : Int = 0
        get
        set

    var Losses : Int = 0
        get
        set

    var HomeStatistic : HomeAwayStatistic? = null
        get
        set

    var AwayStatistic : HomeAwayStatistic? = null
        get
        set
}