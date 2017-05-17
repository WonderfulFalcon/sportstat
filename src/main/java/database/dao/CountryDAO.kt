package database.dao

import database.entity.Country
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Service
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

/**
 * Created by WonderfulFalcon on 13.05.2017.
 */
@Service
class CountryDAO(var dataSource : DriverManagerDataSource)
{
    fun getAllCounties() : MutableList<Country>
    {
        var sql : String = "SELECT * FROM \"Country\"";

        var conn : Connection

        try {
            conn = dataSource.getConnection();
            var ps : PreparedStatement = conn.prepareStatement(sql);
            var rs : ResultSet = ps.executeQuery();
            var countryList : MutableList<Country> = ArrayList()
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
}


