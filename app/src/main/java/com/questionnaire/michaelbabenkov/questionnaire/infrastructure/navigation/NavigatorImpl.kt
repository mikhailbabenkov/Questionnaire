package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation

import android.content.Context
import android.widget.Toast
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainActivity
import com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire.QuestionnaireActivity

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

    override fun navigateToSummary(context: Context, points: Int) {
        Toast.makeText(context, "Points:$points", Toast.LENGTH_LONG).show()
        val intent = MainActivity.createLaunchIntent(context)
        context.startActivity(intent)
//        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}