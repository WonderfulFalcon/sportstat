package footballstat.database.dao.javasql

import footballstat.database.dao.DAO
import footballstat.database.entity.CountryEntity
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Service
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.Transactional
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*
import javax.sql.DataSource


@Service
open class CountryDAO : DAO<CountryEntity>
{
    val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var jdbcTeamplate: JdbcTemplate

    override fun delete(id: Int): Boolean
    {
        val sql: String = "DELETE FROM \"Country\" WHERE id=$id";
        val deletedRows = jdbcTeamplate.update(sql)
        return deletedRows > 0
    }

    override fun getAll(): Collection<CountryEntity>
    {
        val sql: String = "SELECT * FROM \"Country\"";
        return jdbcTeamplate.query(sql, BeanPropertyRowMapper(CountryEntity::class.java))
    }

    override fun getById(id: Int): CountryEntity?
    {
        val sql: String = "SELECT * FROM \"Country\" WHERE id=$id";
        try
        {
            return jdbcTeamplate.queryForObject(sql, BeanPropertyRowMapper(CountryEntity::class.java))
        }
        catch(e: EmptyResultDataAccessException)
        {
            logger.warn("Country with id = $id not found", e)
            return null;
        }
    }

    override fun insert(obj: CountryEntity): CountryEntity
    {
        val sql: String = "INSERT INTO \"Country\" (name) VALUES (\'${obj.Name}\')"
        jdbcTeamplate.update(sql)
        val lastInsertedSql = "SELECT * FROM \"Country\" WHERE id = lastval()";
        return jdbcTeamplate.queryForObject(lastInsertedSql, BeanPropertyRowMapper(CountryEntity::class.java))
    }

    override fun insertAll(listOfObj: Collection<CountryEntity>)
    {
        listOfObj.forEach { ce -> insert(ce) }
    }
}


