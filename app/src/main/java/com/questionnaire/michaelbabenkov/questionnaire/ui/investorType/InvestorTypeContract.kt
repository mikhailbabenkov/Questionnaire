package com.questionnaire.michaelbabenkov.questionnaire.ui.investorType

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 16/01/17.
 */
interface InvestorTypeContract {
    interface View {
        fun setDescription(descRes: Int)
        fun setChart(chartRes: Int)
    }

    interface Presenter : BasePresenter<View> {
        var investorType: InvestorType
        fun restoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState(outState: Bundle)
    }

}