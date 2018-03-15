package footballstat.controllers

import footballstat.model.football.*
import footballstat.services.SportData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
open class HomeController
{
    @Autowired
    lateinit var sportData : SportData

    @RequestMapping(value = "/")
    open fun home() : ModelAndView
    {
        return ModelAndView("home")
    }

    @PostMapping(value = "/availableLeagues")
    @ResponseBody
    open fun availableLeagues() : List<LeagueInfo>
    {
        return sportData.getAvailableLeagues()
    }

    @PostMapping(value = "/league")
    @ResponseBody
    open fun league(@RequestParam("leagueId", required = true) leagueId : String,
                    @RequestParam("matchDay", required = true) matchDay : Int) : League
    {
        return sportData.getLeague(leagueId, matchDay)
    }

    @PostMapping(value = "/teamPlayers")
    @ResponseBody
    open fun teamPlayers(@RequestParam("teamId", required = true) teamId : Int) : Collection<Player>
    {
        return sportData.getTeamSquad(teamId);
    }

    @PostMapping(value = "/matches")
    @ResponseBody
    open fun leagueMatches(@RequestParam("leagueId", required = true) leagueId: String,
                           @RequestParam("matchDay", required = true) matchDay: Int) : Set<Match>
    {
        return sportData.getMatches(leagueId, matchDay);
    }

    @PostMapping(value = "/teamsForm")
    @ResponseBody
    open fun teamsForm(@RequestParam("leagueId", required = true) leagueId: String,
                                      @RequestParam("matchesCount", required = false) matchesCount: Int = 5) : List<TeamForm>
    {
        return sportData.getTeamsForm(leagueId, matchesCount);
    }
}
