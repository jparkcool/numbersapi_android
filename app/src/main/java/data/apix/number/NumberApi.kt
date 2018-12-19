package data.apix.number

import data.entity.Num
import data.source.temp.ResponseObject
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NumberApi {
    private const val URL_BASE = "http://numbersapi.com/"

    fun num(observable: PublishSubject<ResponseObject>, num: Int): Call<Num> {
        val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(NumberApiService::class.java)
        val call = service.num(num)
        call.enqueue(object : Callback<Num> {
            override fun onResponse(call: Call<Num>, response: Response<Num>) {
                val numObj = response.body() as Num
                println("body: " + numObj!!)
                observable.onNext(ResponseObject("", "", numObj))
            }

            override fun onFailure(call: Call<Num>, t: Throwable) {
                println("t: " + t.message)
            }
        })

        return call
    }
}
