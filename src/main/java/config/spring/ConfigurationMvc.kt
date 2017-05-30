package config.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@EnableWebMvc
@Configuration
@ComponentScan(value="controllers")
open class ConfigurationMvc : WebMvcConfigurerAdapter()
{
    @Bean
    open fun viewResolver() : InternalResourceViewResolver
    {
        val resolver: InternalResourceViewResolver = InternalResourceViewResolver()
        resolver.setViewClass(JstlView::class.java)
        resolver.setPrefix("/WEB-INF/views/")
        resolver.setSuffix(".jsp")
        return resolver
    }
}
