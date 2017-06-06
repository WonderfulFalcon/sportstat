package footballstat.controllers

import footballstat.config.business.UserConfig
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
    lateinit var userConfig: UserConfig

    @RequestMapping(value = "/home.htm")
    open fun mainTable(@CookieValue(value = "leagueId", required = false) leagueId: Int?) : ModelAndView
    {
        val view : ModelAndView = ModelAndView("home")
        view.addObject("league", sportData.getCurrentLeague(leagueId ?: userConfig.defaultLeagueId))
        return view
    }

    @PostMapping(value = "/leagueTable")
    open fun leagueTable(@RequestParam("leagueId", required = true) leagueId : Int,
                         @RequestParam("matchDay", required = true) matchDay : Int) : ModelAndView
    {
        val view : ModelAndView = ModelAndView("leagueTable")
        return view
    }
}
