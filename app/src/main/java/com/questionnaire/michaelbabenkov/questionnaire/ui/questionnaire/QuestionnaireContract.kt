package com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.ui.BasePresenter

/**
 * Created by michael.babenkov on 13/01/17.
 */
interface QuestionnaireContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun submitAnswer(points: Int, shouldEnd: Boolean = false, nextQuestion: Question?)
        fun setupQuestion(questionRes: Int)
        fun getSelectedAnswer(): Int
        fun showEmptySelectionDialog()
    }

    interface Presenter : BasePresenter<View> {
        var existingPoints: Int
        var question: Question
        fun onNextClicked()
        fun restoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState(outState: Bundle)
    }

    interface Callback {
        fun goNext(existingPoints: Int, nextQuestion: Question)
        fun finishQuestionnaire(points: Int)
    }
}