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

    var competitionUrl : String = ""

    var leagueSuffix : String = ""

    var matchDayFilter : String = ""
}