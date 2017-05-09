package servlet

import config.Configuration
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer


class ServletInitializer : AbstractAnnotationConfigDispatcherServletInitializer()
{
    override fun getRootConfigClasses(): Array<out Class<*>>? {
        return null
    }

    override fun getServletConfigClasses(): Array<out Class<*>>? {
        return arrayOf(Configuration::class.java)
    }

    override fun getServletMappings(): Array<out String>? {
        return arrayOf("/")
    }

}