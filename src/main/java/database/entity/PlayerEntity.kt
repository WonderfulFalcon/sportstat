package database.entity

import database.dao.constants.Man
import database.dao.constants.PlayerRole
import database.dao.constants.WorkingLeg
import java.util.*

class PlayerEntity(id : Long) : Man()
{
    val Id : Long = id
        get

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

    override fun equals(other: Any?): Boolean
    {
        if (other == null)
        {
            return false
        }

        if (other !is PlayerEntity)
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