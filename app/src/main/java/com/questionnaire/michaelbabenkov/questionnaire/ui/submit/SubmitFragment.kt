package com.questionnaire.michaelbabenkov.questionnaire.ui.submit

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.questionnaire.michaelbabenkov.questionnaire.BR
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.FragmentSubmitBinding
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainContract
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SubmitFragment: BaseCallbackFragment<SubmitContract.Callback>(), SubmitContract.View {

    private lateinit var fragmentDataBinding: FragmentSubmitBinding
    private lateinit var viewModel: SubmitViewModel
    private val presenter: SubmitContract.Presenter
            by lazy { activityInjektScope.get<SubmitContract.Presenter>() }

    companion object {
        val EXTRA_VIEW_MODEL = "extra-view-model"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) {
            viewModel = SubmitViewModel()
        } else {
            viewModel = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL)
        }
        presenter.view = this
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataBinding = DataBindingUtil.bind(view)
        fragmentDataBinding.setVariable(BR.viewModel, viewModel)
        fragmentDataBinding.setVariable(BR.presenter, presenter)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_VIEW_MODEL, viewModel)
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

    override fun getName(): String {
        return viewModel.name
    }

    override fun getEmail(): String {
        return viewModel.email
    }

    override fun getPhone(): String {
        return viewModel.phone
    }

    override fun submitForm(form: SubmitForm) {
        callback?.sendFormEmail(form)
    }

    override fun showInvalidEmailMessage() {
        viewModel.emailError = getString(R.string.msg_invalid_email)
    }

    override val layoutResId: Int
        get() = R.layout.fragment_submit
}