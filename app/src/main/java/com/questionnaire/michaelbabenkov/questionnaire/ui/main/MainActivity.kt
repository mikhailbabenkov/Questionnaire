package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseMenuActivity

/**
 * Created by michael.babenkov on 12/01/17.
 */
class MainActivity: BaseMenuActivity(), MainContract.Callback {

    companion object {
        fun createLaunchIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }

    override val selectedItem: Int?
        get() = null

    override fun setSubmitState(state: SubmitState) {
        val item = binding.navigationView.menu.findItem(R.id.nav_submit)
        when(state) {
            SubmitState.DISABLED -> {
                item.isEnabled = false
            }
            SubmitState.ENABLED -> {
                item.isEnabled = true
            }
            SubmitState.SUBMITTED -> {
                item.isEnabled = false
                item.title = "Submitted"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) {
            changeFragment(fragment = MainFragment())
        }
        binding.navigationView.menu.findItem(R.id.nav_submit).isEnabled = false
    }
}