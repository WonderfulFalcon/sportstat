package database

import config.ConfigurationDataBase
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.io.File
import java.nio.charset.Charset
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException


fun main(args: Array<String>)
{
    val dataSource: DriverManagerDataSource = ConfigurationDataBase().dataSource()
    val sql: String = File(System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/sql/sql").readText(Charset.defaultCharset())

    try
    {
        val conn: Connection = dataSource.getConnection();
        val ps: PreparedStatement = conn.prepareStatement(sql);
        ps.executeQuery();
        println("SUCCESS")
    }
    catch (e: SQLException)
    {
        println("FAIL")
        throw RuntimeException(e)
    }
}


