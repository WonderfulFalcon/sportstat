package footballstat.controllers

import footballstat.model.football.League
import footballstat.model.football.LeagueInfo
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

    @RequestMapping(value = "/home.htm")
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
    open fun league(@RequestParam("leagueId", required = true) leagueId : Int,
                         @RequestParam("matchDay", required = true) matchDay : Int) : League
    {
        return sportData.getLeague(leagueId, matchDay)
    }

    @PostMapping(value = "/teamPlayers")
    open fun teamPlayers(@RequestParam("teamId", required = true) teamId : Int) : ModelAndView
    {
        val view : ModelAndView = ModelAndView("teamPlayers")
        view.addObject("players", sportData.getTeamSquad(teamId))
        return view
    }
}
