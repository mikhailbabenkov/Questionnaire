package com.questionnaire.michaelbabenkov.questionnaire.utils

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import rx.Scheduler
import rx.schedulers.Schedulers

/**
 * Created by michael.babenkov on 16/01/17.
 */
class TestUiThread : ExecutionThread() {

    var observer : Scheduler = Schedulers.immediate()
    var subscribe : Scheduler = Schedulers.immediate()

    //need to run the rx / fake response in the same thread then unit testing
    override fun getObserverThread(): Scheduler = observer
    override fun getSubscribeThread(): Scheduler = subscribe
}