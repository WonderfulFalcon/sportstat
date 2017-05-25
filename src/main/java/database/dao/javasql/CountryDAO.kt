package database.dao.javasql

import database.dao.DAO
import database.entity.CountryEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Service
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*


@Service
open class CountryDAO : DAO<CountryEntity>
{
    @Autowired
    lateinit var dataSource : DriverManagerDataSource

    override fun getAll(): Collection<CountryEntity>
    {
        val sql : String = "SELECT * FROM \"Country\"";

        val conn : Connection

        try {
            conn = dataSource.getConnection();
            val ps : PreparedStatement = conn.prepareStatement(sql);
            val rs : ResultSet = ps.executeQuery();
            val countryEntityList: MutableList<CountryEntity> = ArrayList()
            if (rs.next())
            {
                countryEntityList.add(CountryEntity(
                        rs.getInt("id"),
                        rs.getString("name")))
            }
            rs.close()
            ps.close()
            return countryEntityList
        } catch (e : SQLException) {
            throw RuntimeException(e)
        }
    }

    override fun getById(id: Int): CountryEntity
    {
        throw UnsupportedOperationException()
    }

    override fun insert(obj: CountryEntity)
    {
        throw UnsupportedOperationException()
    }

    override fun insertAll(listOfObj: Collection<CountryEntity>)
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


