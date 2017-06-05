package footballstat.config.business

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties
@PropertySource("classpath:config/user.cfg.yml")
class UserConfig
{
    var defaultLeagueId : Int = 0
}