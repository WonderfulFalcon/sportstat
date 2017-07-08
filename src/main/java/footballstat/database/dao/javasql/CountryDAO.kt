package footballstat.database.dao.javasql

import footballstat.database.dao.DAO
import footballstat.database.entity.CountryEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Service
import org.springframework.transaction.PlatformTransactionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*
import javax.sql.DataSource


@Service
open class CountryDAO : DAO<CountryEntity>
{
    @Autowired
    lateinit var dataSource : DataSource

    @Autowired
    lateinit var transactionManager : PlatformTransactionManager

    override fun delete(id: Int): Boolean
    {
        val sql : String = "DELETE FROM \"Country\" WHERE id=$id";
        val conn : Connection
        conn = dataSource.getConnection();
        try {
            val ps : PreparedStatement = conn.prepareStatement(sql);
            val count = ps.executeUpdate()
            ps.close()
            return count > 0
        } catch (e : SQLException) {
            throw RuntimeException(e)
        }
        finally {
            conn.close()
        }
    }

    override fun getAll(): Collection<CountryEntity>
    {
        val sql : String = "SELECT * FROM \"Country\"";

        val conn : Connection
        conn = dataSource.getConnection();
        try {

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
        finally {
            conn.close()
        }
    }

    override fun getById(id: Int): CountryEntity?
    {
        val sql : String = "SELECT * FROM \"Country\" WHERE id=$id";

        val conn : Connection
        conn = dataSource.getConnection();
        try {

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
            return countryEntityList.getOrNull(0);
        } catch (e : SQLException) {
            throw RuntimeException(e)
        }
        finally {
            conn.close()
        }
    }

    override fun insert(obj: CountryEntity) : CountryEntity
    {
        val sql : String = "INSERT INTO \"Country\" (name) VALUES (\'${obj.Name}\')"

        val conn : Connection
        conn = dataSource.connection
        try {

            val ps : PreparedStatement = conn.prepareStatement(sql)
            ps.execute()
            ps.close()
        } catch (e : SQLException) {
            conn.close()
            throw RuntimeException(e)
        }

        val lastInsertedSql = "SELECT * FROM \"Country\" WHERE id = lastval()";
        try
        {
            val statement = conn.prepareStatement(lastInsertedSql)
            val rs = statement.executeQuery();

            val list: MutableList<CountryEntity> = ArrayList()
            if (rs.next())
            {
                list.add(CountryEntity(
                        rs.getInt("id"),
                        rs.getString("name")))
            }
            if (list.isNotEmpty())
            {
                return list.get(0)
            }
            throw RuntimeException("INSERT FAILED")
        }
        catch (e: SQLException)
        {
            throw RuntimeException(e)
        }
        finally
        {
            conn.close()
        }
    }

    override fun insertAll(listOfObj: Collection<CountryEntity>)
    {
        listOfObj.forEach { ce -> insert(ce) }
    }
}


