package footballstat.services

import footballstat.model.football.League
import footballstat.model.football.LeagueSummary
import org.springframework.stereotype.Component

@Component
class LeagueHandler
{
    fun getSummary(league : League) : LeagueSummary
    {
        return with(LeagueSummary())
        {
            val table = league.Tables[0] // return in dependencies at league type !!!
            Round = league.MatchDay
            TotalGoals = table.Teams.map { it.Statistic.GoalsScored }.sum()
            AverageMatchGoals = TotalGoals / (Round.toFloat() * table.Teams.size / 2)
            this
        }
    }
}