package footballstat

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer


@SpringBootApplication
open class Application : SpringBootServletInitializer()
{
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }
}

@Throws(Exception::class)
fun main(args: Array<String>) {
    SpringApplication.run(arrayOf(Application::class.java), args)
}