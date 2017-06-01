package footballstat.database.entity

import java.util.*

class TeamDetailsEntity(id : Long)
{
    val Id : Long = id
        get

    var Position : Int? = null
        get
        set

    var Players : Collection<Int>? = HashSet()
        get
        set

    var Coaches : Collection<Int>? = HashSet()
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

        if (other !is TeamDetailsEntity)
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