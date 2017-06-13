package footballstat.controllers

import footballstat.config.business.UserConfig
import footballstat.services.LeagueHandler
import footballstat.services.SportData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
open class HomeController
{
    @Autowired
    lateinit var sportData : SportData

    @Autowired
    lateinit var userConfig : UserConfig

    @Autowired
    lateinit var leagueHandler : LeagueHandler

    @RequestMapping(value = "/home.htm")
    open fun home() : ModelAndView
    {
        val view = ModelAndView("home")
        val leagues = sportData.getAvailableLeagues()

        view.addObject("leagueInfo", leagues)
        return view
    }

    @PostMapping(value = "/league")
    open fun league(@RequestParam("leagueId", required = true) leagueId : Int,
                         @RequestParam("matchDay", required = false) matchDay : Int?) : ModelAndView
    {
        val view : ModelAndView = ModelAndView("league")
        val league = sportData.getLeague(leagueId, matchDay)

        val matches = sportData.getMatches(leagueId, 38)

        view.addObject("league", sportData.getLeague(leagueId, matchDay))
        view.addObject("leagueSummary", leagueHandler.getSummary(league))
        return view
    }

    @PostMapping(value = "/teamPlayers")
    open fun teamPlayers(@RequestParam("teamId", required = true) teamId : Int) : ModelAndView
    {
        val view : ModelAndView = ModelAndView("teamPlayers")
        view.addObject("players", sportData.getTeamSquad(teamId))
        return view
    }
}
