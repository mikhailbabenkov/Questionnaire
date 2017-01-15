package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared

import com.questionnaire.michaelbabenkov.questionnaire.R

/**
 * Created by michael.babenkov on 12/01/17.
 */
enum class Question(val questionRes: Int, val answersResArray: Int, val finalAnswerIds: IntArray?) {
    ONE(R.string.lbl_question_1, R.array.answers_1, intArrayOf(0,1)),
    TWO(R.string.lbl_question_2, R.array.answers_2, null),
    THREE(R.string.lbl_question_3, R.array.answers_3, null),
    FOUR(R.string.lbl_question_4, R.array.answers_4, null),
    FIVE(R.string.lbl_question_5, R.array.answers_5, intArrayOf(0,1,2,3,4)),
}