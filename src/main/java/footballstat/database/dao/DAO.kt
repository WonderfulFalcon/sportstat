package footballstat.database.dao


interface DAO<T>
{
    fun getAll() : Collection<T>
    fun getById(id: String): T?
    fun insert(obj: T) : T?
    fun insertAll(listOfObj: Collection<T>)
    fun delete(id: String) : Boolean
    fun getByExample(example: T) : Collection<T>
    //TODO  fun update(obj: T) : Boolean
}