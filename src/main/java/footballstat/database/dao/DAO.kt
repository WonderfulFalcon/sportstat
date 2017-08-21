package footballstat.database.dao


interface DAO<T>
{
    fun findAll() : Collection<T>
    fun findOne(id: Int) : T?
    fun insert(obj: T) : T?
    fun insertAll(listOfObj: Collection<T>)
    fun remove(id: Int) : Boolean
}