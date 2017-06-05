package footballstat.config.external

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties
@PropertySource("classpath:config/externalProvider.cfg.yml")
open class ExternalProviderConfig
{
    public var userAgent : String = ""
    public var xAuthToken : String = ""
}