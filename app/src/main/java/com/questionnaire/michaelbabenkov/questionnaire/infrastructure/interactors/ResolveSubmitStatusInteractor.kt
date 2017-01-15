package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import rx.Subscriber

/**
 * Created by michael.babenkov on 12/01/17.
 */
interface ResolveSubmitStatusInteractor: Interactor<SubmitState> {
    fun getSubmitState(subscriber : Subscriber<SubmitState>)
}