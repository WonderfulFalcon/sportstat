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


@Service
class CountryDAO(var dataSource : DriverManagerDataSource)
{
    fun getAllCounties() : Collection<Country>
    {
        val sql : String = "SELECT * FROM \"Country\"";

        val conn : Connection

        try
        {
            conn = dataSource.connection;
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
        }
        catch (e : SQLException)
        {
            throw RuntimeException(e)
        }
    }
}


