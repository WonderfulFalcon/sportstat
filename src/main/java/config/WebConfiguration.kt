package config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import services.SportDataService

@Configuration
open class WebConfiguration
{
    @Bean
    open fun sportData() : SportDataService = SportDataService()
}