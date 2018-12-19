package data.repository

import data.apix.number.NumberApi
import data.source.temp.RequestObject
import data.source.temp.ResponseObject
import data.source.temp.ResponseRecipient
import io.reactivex.subjects.PublishSubject

object BaseRepository {
    fun num(number: Int): RequestObject {
        val subject = ResponseRecipient.publishSubject
        val call = NumberApi.num(subject, number)

        val publisher = PublishSubject.create<ResponseObject>()
        subject.subscribe(publisher)

        val requestContainer = RequestObject(call, publisher)
        return requestContainer
    }

}
