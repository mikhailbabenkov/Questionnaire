package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 13/01/17.
 */
interface SummaryContract {
    interface View {
        fun showPoints(points: Int)
        fun showInvestorType(investorType: String)
        fun showInvestorInfoScreen(investorType: InvestorType)
    }

    interface Presenter : BasePresenter<View> {
        var points: Int
        fun restoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState(outState: Bundle)
        fun onShowClicked()
    }

    interface Callback {
        fun showInvestorInfoScreen(investorType: InvestorType)
    }
}