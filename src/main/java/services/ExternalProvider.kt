package services

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Component
open class ExternalProvider
{
    fun getResponse(requestUrl : String) : StringBuffer
    {
        val connection = URL(requestUrl).openConnection() as HttpURLConnection

        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        connection.setRequestProperty("X-Auth-Token", "b821e893b7234fe19c4e754f431b476a")

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