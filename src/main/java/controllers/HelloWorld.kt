package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class HelloWorld
{
    @RequestMapping(value = "/hui.htm")
    open fun helloWorld(): String
    {
        return "hello";
    }
}
