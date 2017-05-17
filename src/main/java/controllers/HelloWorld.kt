package controllers

import database.dao.CountryDAO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
open class HelloWorld(var countryDAO: CountryDAO)
{
    @RequestMapping(value = "/hui.htm")
    open fun helloWorld(): ModelAndView
    {
        var mav : ModelAndView = ModelAndView("hello")
        mav.addObject("countries", countryDAO.getAllCounties())
        return mav
    }
}
