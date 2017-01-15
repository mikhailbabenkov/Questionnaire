package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.BaseInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitPointsInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.QuestionnaireRepository
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 13/01/17.
 */
class SubmitPointsInteractorImpl(
        private val questionaryRepository: QuestionnaireRepository = Injekt.get()) :
        BaseInteractor<Int>(), SubmitPointsInteractor {

    override fun submitPoints(points: Int, subscriber: Subscriber<Int>) {
        execute({questionaryRepository.submitPoints(points)}, subscriber = subscriber)
    }
}