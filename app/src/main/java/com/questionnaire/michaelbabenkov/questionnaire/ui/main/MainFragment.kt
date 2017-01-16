package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.Toolbar
import android.view.View
import com.questionnaire.michaelbabenkov.questionnaire.BR
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.FragmentMainBinding
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseFragment
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 12/01/17.
 */
class MainFragment: BaseCallbackFragment<MainContract.Callback>(), MainContract.View{

    private lateinit var fragmentDataBinding: FragmentMainBinding
    private val viewModel: MainViewModel by lazy { MainViewModel() }
    private val presenter: MainContract.Presenter
            by lazy { activityInjektScope.get<MainContract.Presenter>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.view = this
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

    override fun showLoading() {
        viewModel.loading = true
    }

    override fun hideLoading() {
        viewModel.loading = false
    }

    override fun setSubmitState(state: SubmitState) {
        callback?.setSubmitState(state)
    }

    override val layoutResId = R.layout.fragment_main
}