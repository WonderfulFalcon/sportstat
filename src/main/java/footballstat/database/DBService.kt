package footballstat.database


import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.File
import java.nio.charset.Charset
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import javax.sql.DataSource

@Component
open class DBService
{
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var dataSource : DataSource

    fun initPostgresqlDB()
    {
        val sql : String = File(this.javaClass.getResource("sql/sql").file).readText(Charset.defaultCharset())

        try
        {
            val conn : Connection = dataSource.getConnection();
            val ps : PreparedStatement = conn.prepareStatement(sql);
            if(!ps.execute())
            {
                logger.error("INIT DATABASE FAILED!")
                throw RuntimeException("java.sql.PreparedStatement.execute return 'false'")
            }
            ps.close()
            conn.close()
        }
        catch (e: SQLException)
        {
            logger.error("INIT DATABASE FAILED!", e)
            throw RuntimeException(e)
        }
    }

    fun testDbConnection() : Boolean
    {
        try
        {
            val conn : Connection = dataSource.getConnection()
            val hasConnection = !conn.isValid(10)
            if(!hasConnection)
            {
                logger.error("ERROR DATABASE CONNECTION")
            }
            conn.close()
            return hasConnection
        }
        catch (e: SQLException)
        {
            logger.error("ERROR DATABASE CONNECTION", e)
        }

        return false;
    }
}


