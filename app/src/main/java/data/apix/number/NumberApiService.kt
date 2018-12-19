package data.apix.number

import data.entity.Num
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NumberApiService {
    //http://numbersapi.com/42?json
    @GET("{num}")
    fun num(@Path("num") num: Int, @Query("json") format: String = ""): Call<Num>
}
