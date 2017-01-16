package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation

import android.content.Context
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType

/**
 * Created by michael.babenkov on 9/01/17.
 */
interface Navigator {
    fun navigateToMain(context: Context)
    fun navigateToQuestionnaire(context: Context)
    fun navigateToSubmit(context: Context)

}