package footballstat.model


class Country(name : String)
{
    val Name : String = name
        get

    override fun toString() : String = "Country : ${Name}"
}