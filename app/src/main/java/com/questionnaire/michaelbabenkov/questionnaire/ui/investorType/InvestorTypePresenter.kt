package com.questionnaire.michaelbabenkov.questionnaire.ui.investorType

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question

/**
 * Created by michael.babenkov on 16/01/17.
 */
class InvestorTypePresenter: InvestorTypeContract.Presenter {

    companion object{
        val STATE_INVESTOR_TYPE = "state-investor-type"
    }

    override fun restoreInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            investorType = savedInstanceState.getSerializable(STATE_INVESTOR_TYPE) as InvestorType
        }
    }

    override fun saveInstanceState(outState: Bundle) {
        outState.putSerializable(STATE_INVESTOR_TYPE, investorType)
    }

    override lateinit var view: InvestorTypeContract.View

    override fun start() {
        view.setDescription(investorType.investorDescRes)
        view.setChart(investorType.investorChartRes)
    }

    override fun stop() {
        //empty state
    }

    override lateinit var investorType: InvestorType

}