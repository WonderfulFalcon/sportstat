package footballstat.database


import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
open class DBService
{
    private val logger = LoggerFactory.getLogger(this.javaClass)

    fun initDB() {}

    fun testDbConnection() : Boolean
    {
        return true
    }
}


