package footballstat.database.entity

import footballstat.database.constants.Man
import footballstat.database.constants.PlayerRole
import footballstat.database.constants.WorkingLeg
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
        if (this === other)
        {
            return true
        }

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