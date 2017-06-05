package footballstat.controllers

import footballstat.config.external.ExternalProviderConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import footballstat.services.SportData
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestParam

@Controller
open class HomeController
{
    @Autowired
    lateinit var sportData : SportData

    @Autowired
    lateinit var externalConfig: ExternalProviderConfig

    @RequestMapping(value = "/home.htm")
    open fun mainTable(@RequestParam(value = "leagueId", required = false) userLeagueId: Int?) : ModelAndView
    {
        val leagueId : Int
        if (userLeagueId == null)
        {
            leagueId = externalConfig.defaultLeagueId
        }
        else
        {
            leagueId = userLeagueId.toInt()
        }

        val view : ModelAndView = ModelAndView("home")
        view.addObject("league", sportData.getCurrentLeague(leagueId))
        return view
    }
}
