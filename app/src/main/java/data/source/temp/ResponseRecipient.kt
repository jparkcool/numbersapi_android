package data.source.temp

import io.reactivex.subjects.PublishSubject

object ResponseRecipient {
    val publishSubject = PublishSubject.create<ResponseObject>()
}
