package database.entity

import java.time.LocalDate
import java.util.*

class PlayerEntity(id : Long)
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

    var Citizenships : Collection<CountryEntity> = ArrayList()
        get
        set

    var DateOfBirth : LocalDate? = null
        get
        set

    var Role : PlayerRole? = null
        get
        set

    var WorkingLeg : WorkingLeg? = null
        get
        set

    var Height : Int? = null
        get
        set

    var Weight : Int? = null
        get
        set

    fun fullName() : String = "$Name $SecondName $SecondName"
}