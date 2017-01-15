package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.os.Bundle
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment

/**
 * Created by michael.babenkov on 13/01/17.
 */
class SummaryFragment: BaseCallbackFragment<SummaryContract.Callback>(), SummaryContract.View {

    companion object {
        val TOTAL_POINTS_EXTRA = "total-points"

        fun newInstance(existingPoints: Int): SummaryFragment {

            val bundle = Bundle().apply {
                putInt(TOTAL_POINTS_EXTRA, existingPoints)
            }

            return SummaryFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun showPoints() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showInvestorType() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showInvestorInfoScreen() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val layoutResId: Int
        get() = R.layout.fragment_summary
}