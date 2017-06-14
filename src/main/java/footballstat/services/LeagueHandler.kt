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
            Round = league.MatchDay
            TotalGoals = league.Teams.map { it.Statistic.GoalsScored }.sum()
            AverageMatchGoals = TotalGoals / (Round.toFloat() * league.Teams.size / 2)
            this
        }
    }
}