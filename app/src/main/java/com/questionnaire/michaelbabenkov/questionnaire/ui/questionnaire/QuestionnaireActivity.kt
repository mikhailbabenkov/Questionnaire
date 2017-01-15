package com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseMenuActivity
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainActivity
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainFragment
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.questionnaire.michaelbabenkov.questionnaire.ui.summary.SummaryContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.summary.SummaryFragment


/**
 * Created by michael.babenkov on 12/01/17.
 */
class QuestionnaireActivity : BaseMenuActivity(), QuestionnaireContract.Callback, SummaryContract.Callback {

    override val selectedItem: Int?
        get() = R.id.nav_questionnaire

    companion object {
        fun createLaunchIntent(context: Context): Intent {
            val intent = Intent(context, QuestionnaireActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragment = QuestionnaireFragment.newInstance(0, Question.ONE)
            changeFragment(fragment = fragment)
        }
        binding.navigationView.menu.findItem(R.id.nav_submit).isVisible = false
        binding.navigationView.setCheckedItem(R.id.nav_questionnaire)
    }

    override fun goNext(existingPoints: Int, nextQuestion: Question) {
        val fragment = QuestionnaireFragment.newInstance(existingPoints, nextQuestion)
        changeFragment(fragment = fragment)
    }

    override fun finishQuestionnaire(points: Int) {
        val fragment = SummaryFragment.newInstance(points)
        changeFragment(fragment)
    }

    override fun onBackPressed() {
        if(currentFragment is SummaryFragment) {
            navigator.navigateToMain(this)
        } else {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
                .setMessage(getString(R.string.msg_quit_questionnaire))
                .setPositiveButton(android.R.string.yes, { dialog, which ->
                    navigator.navigateToMain(this)
                })
                .setNegativeButton(android.R.string.no, null)
                .show()
    }

    override fun showInvestorInfoScreen(points: Int) {
//        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}