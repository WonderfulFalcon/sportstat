package config.spring

import config.application.ConfigurationDataBase
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer


class ApplicationConfig : AbstractAnnotationConfigDispatcherServletInitializer()
{
    override fun getRootConfigClasses(): Array<out Class<*>>? {
        return arrayOf(ConfigurationDataBase::class.java, WebConfiguration::class.java)
    }

    override fun getServletConfigClasses(): Array<out Class<*>>? {
        return arrayOf(ConfigurationMvc::class.java)
    }

    override fun getServletMappings(): Array<out String>? {
        return arrayOf("/")
    }

}