package services.providers

import database.dao.DAO
import model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import services.DataItems

class CountryProvider
{
    @Component
    class InternalCountryProvider : DataItems.Countries
    {
        @Autowired
        lateinit var countryDAO: DAO<database.entity.Country>

        override fun getCountries(): Collection<Country>
        {
            try
            {
                return countryDAO.getAll().map{ c -> Country(c.name) };
            }
            catch(e : RuntimeException)
            {
                return emptyList();
            }
        }
    }

    @Component
    class ApiCountryProvider : DataItems.Countries
    {
        override fun getCountries(): Collection<Country>
        {
            throw UnsupportedOperationException()
        }
    }
}