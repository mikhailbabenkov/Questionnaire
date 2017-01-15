package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors

import rx.Subscriber

/**
 * Created by michael.babenkov on 12/01/17.
 */
interface Interactor<T> {
    fun subscribe(subscriber: Subscriber<T>)
    fun unsubscribe()
}