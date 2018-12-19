package data.source.temp

import data.entity.Num
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import java.util.*

class RequestObject(val call: Call<Num>, val publisher: PublishSubject<ResponseObject>) {
    val id: String = UUID.randomUUID().toString()
}
