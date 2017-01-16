package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import rx.Subscriber

/**
 * Created by michael.babenkov on 16/01/17.
 */
interface SubmitFormInteractor: Interactor<SubmitForm> {
    fun submitForm(name: String, email: String, phone: String, subscriber : Subscriber<SubmitForm>)
}