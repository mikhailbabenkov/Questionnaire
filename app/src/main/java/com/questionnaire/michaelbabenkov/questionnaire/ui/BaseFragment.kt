package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by michael.babenkov on 12/01/17.
 */
abstract class BaseFragment : Fragment() {

    open val layoutResId: Int = -1

    val activityInjektScope by lazy {
        if (activity is BaseActivity) (activity as BaseActivity).activityScope
        else throw IllegalStateException("Activity doesn't inherent from ${BaseActivity::class.java.name}")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (layoutResId != -1) {
            return inflater.inflate(layoutResId, container, false)
        } else {
            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

//        fun showDialog(
//                tag : String? = null,
//                title: String? = null,
//                message : String,
//                vararg buttons : AlertDialogFragment.AlertButton) {
//            val DIALOG_TAG = "tag-alert-dialog"
//            if(childFragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
//                AlertDialogFragment.newInstance(
//                        tag = tag, title = title, message = message, buttons = *buttons).show(childFragmentManager, DIALOG_TAG)
//            }
//        }
}