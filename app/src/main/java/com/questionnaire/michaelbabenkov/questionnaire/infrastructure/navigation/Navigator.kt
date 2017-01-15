package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation

import android.content.Context

/**
 * Created by michael.babenkov on 9/01/17.
 */
interface Navigator {
    fun navigateToMain(context: Context)
    fun navigateToQuestionnaire(context: Context)
    fun navigateToSummary(context: Context, points: Int)
}