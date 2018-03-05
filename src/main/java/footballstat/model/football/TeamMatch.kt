package footballstat.model.football


class TeamMatch
{
    val Label: String
    val Result: String

    constructor(teamName: String, match: Match)
    {
        Label = "${match.HomeTeamName} ${match.GoalsHomeTeam}-${match.GoalsAwayTeam} ${match.AwayTeamName}"
        Result = getResult(teamName == match.HomeTeamName, match.GoalsHomeTeam!! - match.GoalsAwayTeam!!)
    }

    fun getResult(isHomeTeam: Boolean, goalsDifference: Int): String
    {
        if (goalsDifference == 0)
        {
            return MatchResult.DRAW.name
        }

        val isHomeTeamWin: Boolean = goalsDifference > 0
        if (isHomeTeam == isHomeTeamWin)
        {
            return MatchResult.WIN.name
        }

        return MatchResult.LOSE.name
    }

    private enum class MatchResult
    {
        WIN,
        LOSE,
        DRAW
    }
}