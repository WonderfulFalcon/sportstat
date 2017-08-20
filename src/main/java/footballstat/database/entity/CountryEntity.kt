package footballstat.database.entity

class CountryEntity()
{
    public constructor(id : Int, name : String) : this()
    {
        Id = id
        Name = name

    }
    public var Id : Int = 0
        get

    public var Name : String = ""
        get

    override fun toString() : String = "id $Id, name $Name"
}