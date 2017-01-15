package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.os.Bundle

/**
 * Created by michael.babenkov on 13/01/17.
 */
class SummaryPresenter: SummaryContract.Presenter {

    companion object {
        val STATE_POINTS = "state-points"
    }

    override lateinit var view: SummaryContract.View

    override var points: Int
        get() = throw UnsupportedOperationException()
        set(value) {}

    override fun restoreInstanceState(savedInstanceState: Bundle?) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveInstanceState(outState: Bundle) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}