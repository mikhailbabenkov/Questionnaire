package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.content.Context

/**
 * Created by michael.babenkov on 12/01/17.
 */
open class BaseCallbackFragment<T> : BaseFragment() {
    protected var callback : T? = null

    @Suppress("UNCHECKED_CAST")
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as T
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }
}