package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.BaseInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitFormInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.QuestionnaireRepository
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SubmitFormInteractorImpl(
        private val questionaryRepository: QuestionnaireRepository = Injekt.get()) :
        BaseInteractor<SubmitForm>(), SubmitFormInteractor {

    override fun submitForm(name: String, email: String, phone: String, subscriber: Subscriber<SubmitForm>) {
        execute({ questionaryRepository.submitForm(name, email, phone) }, subscriber = subscriber)
    }
}