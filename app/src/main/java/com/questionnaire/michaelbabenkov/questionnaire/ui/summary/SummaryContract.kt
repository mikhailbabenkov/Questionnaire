package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 13/01/17.
 */
interface SummaryContract {
    interface View {
        fun showPoints()
        fun showInvestorType()
        fun showInvestorInfoScreen()
    }

    interface Presenter : BasePresenter<View> {
        var points: Int
        fun restoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState(outState: Bundle)
    }

    interface Callback {
        fun showInvestorInfoScreen(points: Int)
    }
}