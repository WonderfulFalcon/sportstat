package footballstat


import footballstat.database.DBService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.stereotype.Component


@SpringBootApplication
open class Application : SpringBootServletInitializer()
{
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder
    {
        return application.sources(Application::class.java)
    }
}

@Throws(Exception::class)
fun main(args: Array<String>)
{
    SpringApplication.run(arrayOf(Application::class.java), args)
}

@Component
open class init : CommandLineRunner
{
    @Autowired
    lateinit var dbService : DBService

    override fun run(vararg args: String?)
    {
        val isConnected = dbService.testDbConnection()
        if (isConnected && args.contains("INITDB"))
        {
            dbService.initPostgresqlDB()
        }
    }
}