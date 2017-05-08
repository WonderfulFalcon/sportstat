package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloWorld
{
    @RequestMapping(value = "/hui.htm")
    fun helloWorld(): String
    {
        return "hello";
    }
}
