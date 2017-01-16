package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType

/**
 * Created by michael.babenkov on 13/01/17.
 */
class SummaryPresenter: SummaryContract.Presenter {

    companion object {
        val STATE_POINTS = "state-points"
    }

    override lateinit var view: SummaryContract.View

    override var points: Int = 0

    override fun restoreInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            points = savedInstanceState.getInt(STATE_POINTS, 0)
        }
    }

    override fun saveInstanceState(outState: Bundle) {
        outState.putInt(STATE_POINTS, points)
    }

    override fun start() {
        view.showPoints(points)
        showSummaryInfo()
    }

    override fun onShowClicked() {
        view.showInvestorInfoScreen(resolveInvestorType())
    }

    private fun showSummaryInfo() {
        val investorType = resolveInvestorType()
        view.showInvestorType(investorType.investorName)
    }

    private fun resolveInvestorType(): InvestorType {
        return when {
            points <= 12 -> InvestorType.DEFENSIVE
            points >= 13 && points <= 20 -> InvestorType.CONSERVATIVE
            points >= 21 && points <= 29 -> InvestorType.BALANCED
            points >= 30 && points <= 37 -> InvestorType.BALANCED_GROWTH
            points >= 38 && points <= 44 -> InvestorType.GROWTH
            points >= 45 && points <= 50 -> InvestorType.AGGRESSIVE_GROWTH
            else -> throw UnsupportedOperationException("Can't be..")
        }
    }

    override fun stop() {

    }

}