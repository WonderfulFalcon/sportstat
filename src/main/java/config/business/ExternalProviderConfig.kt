package config.business

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component


@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "footballDataOrg", locations = arrayOf("external.properties"))
class ExternalProviderConfig
{
    val userAgent : String = ""

    val xAuthToken : String = ""
}