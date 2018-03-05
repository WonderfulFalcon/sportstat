package footballstat.model.football

/**
 * Нулевой индекс списка матчей должен соответствовать последнему сыгранному матчу
 */
class TeamForm
{
    val TeamId: String
    val Matches: List<TeamMatch>
    constructor(team : Team, matches : List<Match>)
    {
        this.TeamId = team.id!!
        this.Matches = matches.map {
            TeamMatch(team.Name!!, it)
        }
    }
}