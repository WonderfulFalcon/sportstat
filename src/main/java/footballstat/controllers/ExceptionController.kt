package footballstat.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
open class ExceptionController
{
    val logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler
    fun logException(request : HttpServletRequest, e : Exception) : ModelAndView
    {
        logger.error("Handle exception from " + request.requestURL, e)
        return ModelAndView("error")
    }
}
