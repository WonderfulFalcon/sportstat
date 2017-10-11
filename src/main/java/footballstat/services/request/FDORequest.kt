package footballstat.services.request

import footballstat.config.business.FDOConfig
import org.apache.http.client.fluent.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FDORequest : RequestProvider
{
    @Autowired
    private lateinit var config: FDOConfig

    override fun getResponse(requestUrl: String): String
    {
        Thread.sleep(3000)
        val request = Request.Get(requestUrl)
        request.addHeader("X-Auth-Token", config.xAuthToken)
        return request.execute().returnContent().asString()
    }
}