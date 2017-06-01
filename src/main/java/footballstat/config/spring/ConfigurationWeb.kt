package footballstat.config.spring

import footballstat.config.business.ExternalProviderConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import footballstat.services.DataItems
import footballstat.services.ExternalProvider
import footballstat.services.SportData
import footballstat.services.providers.CountryProvider
import footballstat.services.providers.TeamsProvider

@Configuration
open class ConfigurationWeb
{
    @Bean
    open fun countries() : DataItems.Countries = CountryProvider.InternalCountryProvider()

    @Bean
    open fun teams() : DataItems.Teams = TeamsProvider.ExternalCountriesProvider()
}