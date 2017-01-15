package com.questionnaire.michaelbabenkov.questionnaire.ui.welcome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseActivity

class WelcomeActivity : BaseActivity() {
    override val layoutResId: Int = R.layout.activity_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun onWelcomeClicked(view: View) {
        navigator.navigateToMain(this)
    }
}
