package footballstat.config.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import footballstat.services.DataItems
import footballstat.services.providers.CountryProvider
import footballstat.services.providers.LeaguesProvider
import footballstat.services.providers.TeamsProvider
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.support.ErrorPageFilter
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties
@PropertySource("classpath:config/datasource.properties")
open class ConfigurationWeb
{
    var datasource : String = ""

    @Bean
    open fun countries() : DataItems.Countries = CountryProvider.InternalCountryProvider()

    @Bean
    open fun teams() : DataItems.Teams {
        if (datasource == "db")
        {
            return TeamsProvider.InternalTeamProvider()
        }
        return TeamsProvider.ExternalTeamsProvider()
    }

    @Bean
    open fun leagues() : DataItems.Leagues {
        if (datasource == "db")
        {
            return LeaguesProvider.InternalLeaguesProvider()
        }
        return LeaguesProvider.InternalLeaguesProvider()
    }

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