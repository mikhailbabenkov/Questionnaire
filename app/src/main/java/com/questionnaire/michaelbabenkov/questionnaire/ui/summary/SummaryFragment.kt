package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.questionnaire.michaelbabenkov.questionnaire.BR
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.FragmentSummaryBinding
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 13/01/17.
 */
class SummaryFragment: BaseCallbackFragment<SummaryContract.Callback>(), SummaryContract.View {

    private val presenter: SummaryContract.Presenter
            by lazy { activityInjektScope.get<SummaryContract.Presenter>() }
    private lateinit var fragmentDataBinding: FragmentSummaryBinding
    private val viewModel: SummaryViewModel by lazy { SummaryViewModel() }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.view = this

        if (savedInstanceState == null) {
            val points = arguments.getInt(TOTAL_POINTS_EXTRA, 0)
            presenter.points = points
        } else {
            presenter.restoreInstanceState(savedInstanceState)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataBinding = DataBindingUtil.bind(view)
        fragmentDataBinding.setVariable(BR.viewModel, viewModel)
        fragmentDataBinding.setVariable(BR.presenter, presenter)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.saveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun showPoints(points: Int) {
        viewModel.points = points.toString()
    }

    override fun showInvestorType(investorType: String) {
        viewModel.investorType = investorType
    }

    override fun showInvestorInfoScreen(investorType: InvestorType) {
        callback?.showInvestorInfoScreen(investorType)
    }

    override val layoutResId: Int
        get() = R.layout.fragment_summary
}