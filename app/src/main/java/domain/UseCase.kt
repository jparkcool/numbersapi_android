package domain

import data.source.temp.ResponseObject
import io.reactivex.subjects.PublishSubject

class UseCase {
    val publisher = PublishSubject.create<ResponseObject>()
}
