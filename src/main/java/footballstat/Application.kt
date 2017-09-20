package footballstat


import footballstat.database.DBService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Component


@SpringBootApplication
@EnableMongoRepositories("footballstat.database.dao.mongodb")
open class Application : SpringBootServletInitializer()
{
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder
    {
        return application.sources(Application::class.java)
    }

    @Component
    open class init : CommandLineRunner
    {
        @Autowired
        lateinit var dbService : DBService

        override fun run(vararg args: String?)
        {
            val isConnected = dbService.testDbConnection()
            if (isConnected && java.lang.Boolean.getBoolean("init"))
            {
                dbService.initDB()
            }
        }
    }
}

@Throws(Exception::class)
fun main(args: Array<String>)
{
    SpringApplication.run(arrayOf(Application::class.java), args)
}

