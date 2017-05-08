package config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@EnableWebMvc
@Configuration
@ComponentScan(value="controllers")
class Configuration
{
    @Bean
    fun viewResolver() : InternalResourceViewResolver
    {
        var resolver: InternalResourceViewResolver = InternalResourceViewResolver()
        resolver.setViewClass(JstlView::class.java)
        resolver.setPrefix("/WEB-INF/views/jsp/")
        resolver.setSuffix(".jsp")
        return resolver
    }
}
