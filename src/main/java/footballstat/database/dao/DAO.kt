package footballstat.database.dao


interface DAO<T>
{
    fun getAll() : Collection<T>
    fun getById(id: Int) : T?
    fun insert(obj: T) : T?
    fun insertAll(listOfObj: Collection<T>)
    fun delete(id: Int) : Boolean
}