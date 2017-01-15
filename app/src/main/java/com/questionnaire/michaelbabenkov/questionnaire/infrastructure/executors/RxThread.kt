package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get
import java.util.concurrent.Executor

/**
 * Created by michael.babenkov on 9/01/17.
 */
class RxThread(val executor: Executor = Injekt.get()): ExecutionThread() {
    override fun getObserverThread(): Scheduler = AndroidSchedulers.mainThread()
    override fun getSubscribeThread(): Scheduler = Schedulers.from(executor)
}