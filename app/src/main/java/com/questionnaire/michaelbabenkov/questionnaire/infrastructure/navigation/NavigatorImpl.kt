package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation

import android.content.Context
import android.widget.Toast
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainActivity
import com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire.QuestionnaireActivity
import com.questionnaire.michaelbabenkov.questionnaire.ui.submit.SubmitActivity

/**
 * Created by michael.babenkov on 9/01/17.
 */
class NavigatorImpl : Navigator {

    override fun navigateToQuestionnaire(context: Context) {
        val intent = QuestionnaireActivity.createLaunchIntent(context)
        context.startActivity(intent)
    }

    override fun navigateToMain(context: Context) {
        val intent = MainActivity.createLaunchIntent(context)
        context.startActivity(intent)
    }

    override fun navigateToSubmit(context: Context) {
        val intent = SubmitActivity.createLaunchIntent(context)
        context.startActivity(intent)
    }


}