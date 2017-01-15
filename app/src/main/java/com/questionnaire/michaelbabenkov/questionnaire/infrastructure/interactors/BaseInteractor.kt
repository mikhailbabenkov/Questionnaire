package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import rx.Observable
import rx.Subscriber
import rx.subjects.ReplaySubject
import rx.subscriptions.Subscriptions
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 9/01/17.
 */
abstract class BaseInteractor<T>(
        private val thread: ExecutionThread = Injekt.get()) {

    private var subject: ReplaySubject<T>? = null

    var internalSubscription = Subscriptions.empty()
    var externalSubscription = Subscriptions.empty()

    fun subscribe(subscriber: Subscriber<T>) {
        val currentSubject = subject
        if (currentSubject != null) {
            externalSubscription = currentSubject
                    .doOnCompleted { subject = null }
                    .doOnError { subject = null }
                    .subscribe(subscriber)
        }
    }

    fun execute(action: () -> Observable<T>, subscriber: Subscriber<T>) {
        val newSubject = ReplaySubject.create<T>()
        externalSubscription = newSubject.subscribe(subscriber)
        executeAction(action, newSubject)
        subject = newSubject
    }

    private fun executeAction(action: () -> Observable<T>, newSubject: ReplaySubject<T>?) {
        internalSubscription = action.invoke()
                .subscribeOn(thread.getSubscribeThread())
                .observeOn(thread.getObserverThread())
                .doOnCompleted { cleanUp() }
                .doOnError { cleanUp() }
                .subscribe(newSubject)
    }

    fun unsubscribe() {
        if (!externalSubscription.isUnsubscribed) {
            externalSubscription.unsubscribe()
        }
    }

    fun stop() {
        if (!internalSubscription.isUnsubscribed) {
            internalSubscription.unsubscribe()
        }
    }

    private fun cleanUp() {
        val currentSubject = subject
        if (currentSubject != null && currentSubject.hasObservers()) {
            subject = null
        }
    }
}
