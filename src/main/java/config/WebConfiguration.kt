package config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import services.DataItems
import services.SportData
import services.providers.CountryProvider

@Configuration
open class WebConfiguration
{
    @Bean
    open fun countries() : DataItems.Countries = CountryProvider.InternalCountryProvider()

    @Bean
    open fun sportData() : SportData = SportData()
}