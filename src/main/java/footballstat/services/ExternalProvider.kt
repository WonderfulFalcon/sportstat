package footballstat.services

import footballstat.config.external.ExternalProviderConfig
import org.apache.http.client.fluent.Request
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class ExternalProvider
{
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var config : ExternalProviderConfig

    fun getResponse(requestUrl : String) : String
    {
        logger.info("Agent = ${config.userAgent}; Token = ${config.xAuthToken};")
        val request = Request.Get(requestUrl)
        return request.execute().returnContent().asString()
    }
}