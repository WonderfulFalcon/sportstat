package footballstat.services.providers


import footballstat.model.Country
import footballstat.services.DataItems
import org.springframework.stereotype.Component

class CountryProvider
{
    @Component
    open class InternalCountryProvider : DataItems.Countries
    {
        override fun getCountries(): Collection<Country>
        {
            throw UnsupportedOperationException()
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