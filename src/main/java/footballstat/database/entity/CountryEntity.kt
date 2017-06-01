package footballstat.database.entity

class CountryEntity(id : Int, name : String)
{
    val Id : Int = id
        get

    val Name : String = name
        get

    override fun toString() : String = "id $Id, name $Name"
}