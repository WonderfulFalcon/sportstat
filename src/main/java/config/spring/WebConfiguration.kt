package config.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import services.DataItems
import services.ExternalProvider
import services.SportData
import services.providers.CountryProvider
import services.providers.TeamsProvider

@Configuration
open class WebConfiguration
{
    @Bean
    open fun externalProvider() : ExternalProvider = ExternalProvider()

    @Bean
    open fun countries() : DataItems.Countries = CountryProvider.InternalCountryProvider()

    @Bean
    open fun teams() : DataItems.Teams = TeamsProvider.ExternalCountriesProvider()

    @Bean
    open fun sportData() : SportData = SportData()
}