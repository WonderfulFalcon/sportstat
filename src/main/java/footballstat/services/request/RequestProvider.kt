package footballstat.services.request

interface RequestProvider
{
    fun getResponse(requestUrl : String) : String
}