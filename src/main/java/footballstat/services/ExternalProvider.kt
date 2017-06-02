package footballstat.services

import org.apache.http.client.fluent.Request
import org.springframework.stereotype.Component

@Component
open class ExternalProvider
{
    fun getResponse(requestUrl : String) : String
    {
        val request = Request.Get(requestUrl)
        return request.execute().returnContent().asString()
    }
}