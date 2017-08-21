package footballstat.database

import footballstat.database.dao.mongodb.CountryMongoDAO
import footballstat.database.entity.CountryEntity
import org.junit.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
open class CountryMongoTest
{
    @Autowired
    lateinit var countryDAO : CountryMongoDAO

    @Test
    fun getAll()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        countryDAO.insert(country)
        val countries = countryDAO.findAll()
        Assert.assertNotNull(countries)
        Assert.assertTrue(countries.isNotEmpty())
    }

    @Test
    fun delete()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        val insertedCountry = countryDAO.insert(country)
        if (insertedCountry != null) {
            countryDAO.remove(insertedCountry.Id)
            val deletedCountry = countryDAO.findOne(insertedCountry.Id)
            Assert.assertNull(deletedCountry)
        }
    }

    @Test
    fun insert()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        val insertedCountry = countryDAO.insert(country)
        Assert.assertNotNull(insertedCountry)
    }
}