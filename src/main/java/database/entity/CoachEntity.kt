package database.entity

import java.time.LocalDate
import java.util.*

class CoachEntity(id : Long)
{
    val Id : Long = id
        get

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

    override fun equals(other: Any?): Boolean
    {
        if (other == null)
        {
            return false
        }

        if (other !is CoachEntity)
        {
            return false
        }
        return Objects.equals(this.Id, other.Id);
    }

    override fun hashCode(): Int
    {
        return Objects.hashCode(Id)
    }
}