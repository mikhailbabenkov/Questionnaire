package com.questionnaire.michaelbabenkov.questionnaire.ui.investorType

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.questionnaire.michaelbabenkov.questionnaire.BR
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.FragmentInvestorTypeBinding
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseFragment
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 16/01/17.
 */
class InvestorTypeFragment: BaseFragment(), InvestorTypeContract.View {

    private val presenter: InvestorTypeContract.Presenter
            by lazy { activityInjektScope.get<InvestorTypeContract.Presenter>() }
    private lateinit var fragmentDataBinding: FragmentInvestorTypeBinding
    private val viewModel: InvestorTypeViewModel by lazy { InvestorTypeViewModel() }

    companion object {
        val INVESTOR_TYPE = "investor-type"

        fun newInstance(investorType: InvestorType): InvestorTypeFragment {

            val bundle = Bundle().apply {
                putSerializable(INVESTOR_TYPE, investorType)
            }

            return InvestorTypeFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val investorType = arguments.getSerializable(INVESTOR_TYPE) as InvestorType
            presenter.investorType = investorType
        } else {
            presenter.restoreInstanceState(savedInstanceState)
        }
        presenter.view = this
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.saveInstanceState(outState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataBinding = DataBindingUtil.bind(view)
        fragmentDataBinding.setVariable(BR.viewModel, viewModel)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun setDescription(descRes: Int) {
        viewModel.description = getString(descRes)
    }

    override fun setChart(chartRes: Int) {
        viewModel.imageRes = chartRes
    }

    override val layoutResId: Int
        get() = R.layout.fragment_investor_type

}