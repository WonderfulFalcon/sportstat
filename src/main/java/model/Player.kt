package model

import java.util.*

class Player(name: String, surname : String)
{
    private val name : String = name
    private val surname : String = surname

    private var secondName : String? = null
    private var citizenships : Collection<Country> = ArrayList()

    val Name : String
        get() = this.name

    val Surname : String
        get() = this.surname

    var SecondName : String?
        get() = this.secondName
        set(value) { this.secondName = value }

    var Citizenships : Collection<Country>
        get() = this.citizenships
        set(value) { this.citizenships = value }
}