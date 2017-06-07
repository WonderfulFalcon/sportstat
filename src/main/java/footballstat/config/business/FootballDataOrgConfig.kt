package footballstat.config.business

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties
@PropertySource("classpath:config/externalProvider.cfg.yml")
open class FootballDataOrgConfig
{
    var userAgent : String = ""
    var xAuthToken : String = ""

    var apiUrl : String = ""
    var apiVersion : String = ""

    var competitions : String = ""
    var teams : String = ""
    var leagueTable : String = ""
    var players : String = ""

    var matchDayFilter : String =""
}