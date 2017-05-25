package database.entity

import database.dao.constants.Man
import java.util.*

class CoachEntity(id : Long) : Man()
{
    val Id : Long = id
        get

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