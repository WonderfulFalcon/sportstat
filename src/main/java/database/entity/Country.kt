package database.entity

/**
 * Created by WonderfulFalcon on 13.05.2017.
 */
class Country(var id: Int, var name: String)
{
    override fun toString() : String = "id $id, name $name"
}