package com.questionnaire.michaelbabenkov.questionnaire.ui.submit

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseActivity

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SubmitActivity: BaseActivity(), SubmitContract.Callback{

    companion object {
        fun createLaunchIntent(context: Context): Intent {
            val intent = Intent(context, SubmitActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) {
            changeFragment(fragment = SubmitFragment())
        }
    }

    override fun sendFormEmail(form: SubmitForm) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "me@example.com", null))
        intent.putExtra(Intent.EXTRA_SUBJECT,
                "My points are")
        intent.putExtra(Intent.EXTRA_TEXT,
                "Hello I am ${form.name}(${form.email})\n." +
                        " My points are ${form.points}.\n" +
                        " Please contact me ${form.phone} ")
        startActivity(Intent.createChooser(intent, "Send email..."))
        finish()
    }

}