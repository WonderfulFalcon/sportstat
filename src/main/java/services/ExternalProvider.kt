package services

import config.business.ExternalProviderConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Component
open class ExternalProvider
{
    @Autowired
    lateinit var externalProviderConfig : ExternalProviderConfig

    fun getResponse(requestUrl : String) : StringBuffer
    {
        val connection = URL(requestUrl).openConnection() as HttpURLConnection

        connection.setRequestProperty("User-Agent", externalProviderConfig.userAgent)
        connection.setRequestProperty("X-Auth-Token", externalProviderConfig.xAuthToken)

        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuffer()

        for (inputLine in reader.readLine())
        {
            response.append(inputLine)
        }

        reader.close()
        return response
    }
}