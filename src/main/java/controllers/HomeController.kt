package controllers

import database.dao.CountryDAO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
open class HomeController()
{
    @RequestMapping(value = "/home.htm")
    open fun mainTable(): ModelAndView
    {
        val view : ModelAndView = ModelAndView("home")
//        view.addObject("countries", countryDAO.getAllCounties())
        return view
    }
}
