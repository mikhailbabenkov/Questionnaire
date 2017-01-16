package com.questionnaire.michaelbabenkov.questionnaire.ui.submit

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 16/01/17.
 */
interface SubmitContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun getName(): String
        fun getEmail(): String
        fun getPhone(): String
        fun submitForm(form: SubmitForm)
        fun showInvalidEmailMessage()
    }

    interface Presenter : BasePresenter<View> {
        fun onSubmitClicked()
    }

    interface Callback {
        fun sendFormEmail(form: SubmitForm)
    }
}