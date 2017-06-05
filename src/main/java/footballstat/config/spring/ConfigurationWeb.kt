package footballstat.config.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import footballstat.services.DataItems
import footballstat.services.providers.CountryProvider
import footballstat.services.providers.LeaguesProvider
import footballstat.services.providers.TeamsProvider
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.support.ErrorPageFilter

@Configuration
open class ConfigurationWeb
{
    @Bean
    open fun countries() : DataItems.Countries = CountryProvider.InternalCountryProvider()

    @Bean
    open fun teams() : DataItems.Teams = TeamsProvider.ExternalTeamsProvider()

    @Bean
    open fun leagues() : DataItems.Leagues = LeaguesProvider.ExternalLeaguesProvider()

    @Bean
    open fun errorPageFilter() : ErrorPageFilter = ErrorPageFilter()

    @Bean
    open fun disableSpringBootErrorFilter(filter : ErrorPageFilter) : FilterRegistrationBean
    {
        val filterRegistrationBean = FilterRegistrationBean()
        filterRegistrationBean.filter = filter
        filterRegistrationBean.isEnabled = false
        return filterRegistrationBean
    }
}