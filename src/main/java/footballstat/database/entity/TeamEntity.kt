package footballstat.database.entity

import java.util.*

class TeamEntity(id : Long)
{
    val Id : Long = id
        get

    var Name : String? = null
        get
        set

    var ShortName : String? = null
        get
        set

    var Country : CountryEntity? = null
        get
        set

    override fun equals(other: Any?): Boolean
    {
        if (this === other)
        {
            return true
        }

        if (other == null)
        {
            return false
        }

        if (other !is TeamEntity)
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