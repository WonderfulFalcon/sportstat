package footballstat.services.providers

import footballstat.database.dao.DAO
import footballstat.database.entity.CountryEntity
import footballstat.model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import footballstat.services.DataItems

class CountryProvider
{
    @Component
    open class InternalCountryProvider : DataItems.Countries
    {
        @Autowired
        lateinit var countryDAO: DAO<CountryEntity>

        override fun getCountries(): Collection<Country>
        {
            try
            {
                return countryDAO.getAll().map{ c -> Country(c.Name) };
            }
            catch(e : RuntimeException)
            {
                return emptyList();
            }
        }
    }

    @Component
    open class ExternalCountryProvider : DataItems.Countries
    {
        override fun getCountries(): Collection<Country>
        {
            throw UnsupportedOperationException()
        }
    }
}