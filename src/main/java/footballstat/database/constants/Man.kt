package footballstat.database.constants

import footballstat.database.entity.CountryEntity
import java.time.LocalDate
import java.util.*

open class Man
{
    var Name : String? = null
        get
        set

    var Surname : String? = null
        get
        set

    var SecondName : String? = null
        get
        set

    var DateOfBirth : LocalDate? = null
        get
        set

    var Citizenships : Collection<CountryEntity> = ArrayList()
        get
        set

    fun fullName() : String = "$Name $SecondName $SecondName"
}