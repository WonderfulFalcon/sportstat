package services


import model.Country
import model.football.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Component
class SportData : DataItems.Leagues, DataItems.Countries, DataItems.Teams
{
    @Autowired
    lateinit var countries : DataItems.Countries

    override fun getTeam(teamId: Int): Team
    {
        val USER_AGENT = "Mozilla/5.0"
        val url = "http://api.football-data.org/v1/competitions/426/leagueTable"
        val obj = URL(url)

        val connection = obj.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", USER_AGENT)
        connection.setRequestProperty("X-Auth-Token", "b821e893b7234fe19c4e754f431b476a")

        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuffer()

        for (inputLine in reader.readLine())
        {
            response.append(inputLine)
        }
        reader.close()

        return Team("a", Country("RUSSIA"))
    }

    override fun getLeague(countryId: Int): Collection<Team>
    {
        throw UnsupportedOperationException()
    }

    override fun getCountries(): Collection<Country>
    {
        try
        {
            return countries.getCountries();
        }
        catch(e : RuntimeException)
        {
            return emptyList();
        }
    }
}