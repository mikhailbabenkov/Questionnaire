package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors

import rx.Subscriber

/**
 * Created by michael.babenkov on 13/01/17.
 */
interface SubmitPointsInteractor: Interactor<Int> {
    fun submitPoints(points: Int, subscriber : Subscriber<Int>)
}