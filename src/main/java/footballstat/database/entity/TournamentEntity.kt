package footballstat.database.entity

import footballstat.database.dao.constants.TournamentType
import java.time.LocalDate
import java.util.*

class TournamentEntity(id : Long, type : TournamentType)
{
    val Id : Long = id
        get

    val Type : TournamentType = type
        get

    var International : Boolean = false
        get
        set

    var Country : CountryEntity? = null
        get

    var Teams : Collection<Int>? = HashSet()
        get
        set

    var StageQuantity : Int? = null
        get
        set

    var TeamQuantity : Int? = null
        get
        set

    var Name : String? = null
        get
        set

    var ShortName : String? = null
        get
        set

    var startDate : LocalDate? = null
        get
        set

    var endDate : LocalDate? = null
        get
        set

    var statistic : TournamentStatistic? = null
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

        if (other !is TournamentEntity)
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
