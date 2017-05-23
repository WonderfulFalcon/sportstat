package database.dao.javasql

import database.dao.DAO
import database.entity.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Service
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*


@Service
open class CountryDAO : DAO<Country>
{
    @Autowired
    lateinit var dataSource : DriverManagerDataSource

    override fun getAll(): Collection<Country>
    {
        val sql : String = "SELECT * FROM \"Country\"";

        val conn : Connection

        try {
            conn = dataSource.getConnection();
            val ps : PreparedStatement = conn.prepareStatement(sql);
            val rs : ResultSet = ps.executeQuery();
            val countryList : MutableList<Country> = ArrayList()
            if (rs.next())
            {
                countryList.add(Country(
                        rs.getInt("id"),
                        rs.getString("name")))
            }
            rs.close()
            ps.close()
            return countryList
        } catch (e : SQLException) {
            throw RuntimeException(e)
        }
    }

    override fun getById(id: Int): Country
    {
        throw UnsupportedOperationException()
    }

    override fun insert(obj: Country)
    {
        throw UnsupportedOperationException()
    }

    override fun insertAll(listOfObj: Collection<Country>)
    {
        throw UnsupportedOperationException()
    }

//    private fun executeCommand(sqlCommand : String?) : ResultSet
//    {
//        tryWithRecource(
//                dataSource.connection.prepareStatement(sqlCommand),
//                { return it.executeQuery() })
//    }

//    inline fun <T:AutoCloseable,R> tryWithRecource(closeable: T, block: (T) -> R): R {
//        try {
//            return block(closeable);
//        } finally {
//            closeable.close()
//        }
//    }
}


