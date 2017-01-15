package com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire

import android.os.Bundle
import android.widget.AdapterView
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitPointsInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 13/01/17.
 */
class QuestionnairePresenter(val submitPointsInteractor: SubmitPointsInteractor = Injekt.get())
    : QuestionnaireContract.Presenter {

    override var existingPoints: Int = 0

    override lateinit var question: Question

    override lateinit var view: QuestionnaireContract.View

    companion object {
        val STATE_POINTS = "state-points"
        val STATE_QUESTION = "state-question"

        val FIRST_ANSWER = 0
        val SECOND_ANSWER = 1
        val THIRD_ANSWER = 2
        val FOURTH_ANSWER = 3
        val FIFTH_ANSWER = 4

        val FIRST_ANSWER_POINTS = 1
        val SECOND_ANSWER_POINTS = 3
        val THIRD__ANSWER_POINTS = 4
        val FOURTH_ANSWER_POINTS = 5
        val FIFTH_ANSWER_POINTS = 7
    }

    override fun onNextClicked() {
        val selectedAnswer = view.getSelectedAnswer()
        if (selectedAnswer == AdapterView.INVALID_POSITION) {
            view.showEmptySelectionDialog()
        } else {
            processAnswer(selectedAnswer)
        }
    }

    private fun processAnswer(selectedAnswer: Int) {
        val finalAnswerIds = question.finalAnswerIds
        if (finalAnswerIds != null) {
            if (finalAnswerIds.contains(selectedAnswer)) {
                submitPoints(selectedAnswer)
            } else {
                view.submitAnswer(
                        points = resolvePoints(selectedAnswer),
                        shouldEnd = false,
                        nextQuestion = resolveNextQuestion())
            }
        } else {
            view.submitAnswer(
                    points = resolvePoints(selectedAnswer),
                    shouldEnd = false,
                    nextQuestion = resolveNextQuestion())
        }

    }

    private fun resolvePoints(selectedAnswer: Int): Int {
        return when(selectedAnswer) {
            FIRST_ANSWER -> existingPoints + FIRST_ANSWER_POINTS
            SECOND_ANSWER -> existingPoints + SECOND_ANSWER_POINTS
            THIRD_ANSWER -> existingPoints + THIRD__ANSWER_POINTS
            FOURTH_ANSWER -> existingPoints + FOURTH_ANSWER_POINTS
            FIFTH_ANSWER -> existingPoints + FIFTH_ANSWER_POINTS
            else -> throw UnsupportedOperationException("Could't be..")
        }
    }

    private fun resolveNextQuestion(): Question {
        return when (question) {
            Question.ONE -> Question.TWO
            Question.TWO -> Question.THREE
            Question.THREE -> Question.FOUR
            Question.FOUR -> Question.FIVE
            else -> throw UnsupportedOperationException("Could't be..")
        }
    }

    private fun submitPoints(selectedAnswer: Int) {
        view.showLoading()
        resolvePoints(selectedAnswer)
        submitPointsInteractor.submitPoints(resolvePoints(selectedAnswer), SubmitPointsSubscriber())

    }

    override fun restoreInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            existingPoints = savedInstanceState.getInt(STATE_POINTS, 0)
            question = savedInstanceState.getSerializable(STATE_QUESTION) as Question
        }
    }

    override fun saveInstanceState(outState: Bundle) {
        outState.putInt(STATE_POINTS, existingPoints)
        outState.putSerializable(STATE_QUESTION, question)
    }


    override fun start() {
        view.setupQuestion(question.questionRes)
        submitPointsInteractor.subscribe(SubmitPointsSubscriber())
    }

    override fun stop() {
        submitPointsInteractor.unsubscribe()
    }

    inner class SubmitPointsSubscriber : Subscriber<Int>() {

        override fun onError(e: Throwable?) {

        }

        override fun onCompleted() {

        }

        override fun onNext(points: Int) {
            view.hideLoading()
            view.submitAnswer(points = points, shouldEnd = true, nextQuestion = null)
        }
    }

}