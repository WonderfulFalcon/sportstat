package footballstat.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import footballstat.services.SportData

@Controller
open class HomeController
{
    @Autowired
    lateinit var sportData : SportData

    @RequestMapping(value = "/home.htm")
    open fun mainTable(): ModelAndView
    {
        val view : ModelAndView = ModelAndView("home")
        view.addObject("teams", sportData.getLeague(0, 0))
        return view
    }
}
