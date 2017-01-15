package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors

import rx.Scheduler

/**
 * Created by michael.babenkov on 9/01/17.
 */
abstract class ExecutionThread {
    abstract fun getSubscribeThread() : Scheduler
    abstract fun getObserverThread() : Scheduler
}