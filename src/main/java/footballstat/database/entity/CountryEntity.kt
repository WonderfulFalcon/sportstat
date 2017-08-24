package footballstat.database.entity

import org.springframework.data.annotation.Id

class CountryEntity()
{
    public constructor(id : Int, name : String) : this()
    {
        Id = id
        Name = name

    }
    @Id
    public var newId : String = ""
        set
        get

    public var Id : Int = 0
        get

    public var Name : String = ""
        get

    override fun toString() : String = "id $Id, name $Name"
}