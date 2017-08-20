package footballstat.database

import footballstat.database.dao.javasql.CountryDAO
import footballstat.database.entity.CountryEntity
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
open class CountryDAOTest
{
    @Autowired
    lateinit var countryDAO : CountryDAO

    @Autowired
    lateinit var dbService : DBService

    @Test
    fun getAll()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        countryDAO.insert(country)
        val countries = countryDAO.getAll()
        Assert.assertNotNull(countries)
        Assert.assertTrue(countries.isNotEmpty())
    }

    @Test
    fun delete()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        val insertedCountry = countryDAO.insert(country)
        Assert.assertTrue(countryDAO.delete(insertedCountry.Id))
        val deletedCountry = countryDAO.getById(insertedCountry.Id)
        Assert.assertNull(deletedCountry)
    }

    @Test
    fun insert()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        val insertedCountry = countryDAO.insert(country)
        Assert.assertNotNull(insertedCountry)
    }
}