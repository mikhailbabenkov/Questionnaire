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
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.ui.investorType.InvestorTypeFragment
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
    }

    override fun goNext(existingPoints: Int, nextQuestion: Question) {
        val fragment = QuestionnaireFragment.newInstance(existingPoints, nextQuestion)
        changeFragment(fragment = fragment)
    }

    override fun finishQuestionnaire(points: Int) {
        binding.navigationView.menu.findItem(R.id.nav_submit).isEnabled = true
        val fragment = SummaryFragment.newInstance(points)
        changeFragment(fragment)
    }

    override fun onBackPressed() {
        when(currentFragment) {
            is SummaryFragment, is InvestorTypeFragment -> {
                navigator.navigateToMain(this)
            }
            else -> showAlertDialog()
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

    override fun showInvestorInfoScreen(investorType: InvestorType) {
        changeFragment(InvestorTypeFragment.newInstance(investorType))
    }


}