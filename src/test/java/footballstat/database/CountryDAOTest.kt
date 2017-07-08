package footballstat.database

import footballstat.database.dao.javasql.CountryDAO
import footballstat.database.entity.CountryEntity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
open class CountryDAOTest
{
    @Autowired
    lateinit var countryDAO : CountryDAO
    @Test
    fun test()
    {
        val country : CountryEntity = CountryEntity(0, "Test")
        val insertedCountry = countryDAO.insert(country)
        val countries = countryDAO.getAll()
        Assert.assertNotNull(countries)
        Assert.assertTrue(countries.isNotEmpty())
        Assert.assertTrue(countryDAO.delete(insertedCountry.Id))
        val countries2 = countryDAO.getAll()
        Assert.assertNotNull(countries2)
    }

//    @Test
//    @Rollback(true)
//    fun test2()
//    {
//        val country : CountryEntity = CountryEntity(0, "Test")
//        val insertedCountry = countryDAO.insert(country)
//        val countries = countryDAO.getAll()
//        Assert.assertNotNull(countries)
//    }
}