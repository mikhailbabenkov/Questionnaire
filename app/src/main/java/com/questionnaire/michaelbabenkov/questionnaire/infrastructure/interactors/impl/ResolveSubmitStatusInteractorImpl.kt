package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.BaseInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.ResolveSubmitStatusInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.QuestionnaireRepository
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 12/01/17.
 */
class ResolveSubmitStatusInteractorImpl (
        private val questionaryRepository: QuestionnaireRepository = Injekt.get()) :
        BaseInteractor<SubmitState>(), ResolveSubmitStatusInteractor {

    override fun getSubmitState(subscriber: Subscriber<SubmitState>) {
        execute({questionaryRepository.getSubmitState()}, subscriber = subscriber)
    }
}