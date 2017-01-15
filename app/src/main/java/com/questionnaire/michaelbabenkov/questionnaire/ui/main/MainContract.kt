package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 12/01/17.
 */
interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun setSubmitState(state: SubmitState)
    }

    interface Presenter : BasePresenter<View> {
        // empty for now
    }

    interface Callback {
        fun setSubmitState(state: SubmitState)
    }
}