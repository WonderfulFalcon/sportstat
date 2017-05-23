package model.football

import model.Country
import java.util.*

class Player(name: String, surname : String)
{
    val Name : String = name
        get

    val Surname : String = surname
        get

    var SecondName : String? = null
        get
        set

    var Citizenships : Collection<Country> = ArrayList()
        get
        set

    var Age : Int? = null
        get
        set
}