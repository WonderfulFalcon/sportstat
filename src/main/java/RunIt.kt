//import javafx.application.Application
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.test.context.ContextConfiguration
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
//import java.io.File
//import java.nio.charset.Charset
//import java.sql.Connection
//import java.sql.PreparedStatement
//import java.sql.SQLException
//import javax.sql.DataSource
//
//@RunWith(SpringJUnit4ClassRunner::class)
//@ContextConfiguration
//class RunIt
//{
//    @Autowired
//    lateinit var dataSource : DataSource
//
//    @Test
//    fun initDb()
//    {
//        val sql : String = File(System.getProperty("user.dir") + "/src/config.main/webapp/WEB-INF/sql/sql").readText(Charset.defaultCharset())
//
//        try
//        {
//            val conn : Connection = dataSource.getConnection();
//            val ps : PreparedStatement = conn.prepareStatement(sql);
//            ps.execute()
//            println("SUCCESS")
//        }
//        catch (e: SQLException)
//        {
//            println("FAIL")
//            throw RuntimeException(e)
//        }
//    }
//}