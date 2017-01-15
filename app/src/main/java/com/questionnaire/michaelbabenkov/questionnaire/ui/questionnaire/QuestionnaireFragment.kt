package com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ArrayAdapter
import com.questionnaire.michaelbabenkov.questionnaire.BR
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.FragmentQuestionnaireBinding
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.Question
import com.questionnaire.michaelbabenkov.questionnaire.ui.BaseCallbackFragment
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainViewModel
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 13/01/17.
 */
class QuestionnaireFragment : BaseCallbackFragment<QuestionnaireContract.Callback>(), QuestionnaireContract.View {

    private val presenter: QuestionnaireContract.Presenter
            by lazy { activityInjektScope.get<QuestionnaireContract.Presenter>() }
    private lateinit var adapter: ArrayAdapter<CharSequence>
    private lateinit var fragmentDataBinding: FragmentQuestionnaireBinding
    private val viewModel: QuestionnaireViewModel by lazy { QuestionnaireViewModel() }

    companion object {
        val EXISTING_POINTS_EXTRA = "existing-points"
        val QUESTION_EXTRA = "question"

        fun newInstance(existingPoints: Int, question: Question): QuestionnaireFragment {

            val bundle = Bundle().apply {
                putInt(EXISTING_POINTS_EXTRA, existingPoints)
                putSerializable(QUESTION_EXTRA, question)
            }

            return QuestionnaireFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.view = this

        if (savedInstanceState == null) {
            val points = arguments.getInt(EXISTING_POINTS_EXTRA, 0)
            val question = arguments.getSerializable(QUESTION_EXTRA) as Question
            presenter.existingPoints = points
            presenter.question = question
        } else {
            presenter.restoreInstanceState(savedInstanceState)
        }

        adapter = ArrayAdapter.createFromResource(context, presenter.question.answersResArray, android.R.layout.simple_list_item_single_choice)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDataBinding = DataBindingUtil.bind(view)
        fragmentDataBinding.setVariable(BR.viewModel, viewModel)
        fragmentDataBinding.setVariable(BR.presenter, presenter)

        fragmentDataBinding.listView.apply {
            adapter = this@QuestionnaireFragment.adapter
        }
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

    override fun getSelectedAnswer(): Int =
        fragmentDataBinding.listView.checkedItemPosition


    override fun showLoading() {
        viewModel.loading = true
    }

    override fun hideLoading() {
        viewModel.loading = false
    }

    override fun setupQuestion(questionRes: Int) {
        viewModel.question = getString(questionRes)
    }

    override fun showEmptySelectionDialog() {
        AlertDialog.Builder(context)
                .setMessage(getString(R.string.msg_please_select_answer))
                .setPositiveButton(android.R.string.ok, null)
                .show()
    }

    override fun submitAnswer(points: Int, shouldEnd: Boolean, nextQuestion: Question?) {
        if(shouldEnd) {
            callback?.finishQuestionnaire(points)
        } else {
            callback?.goNext(points, nextQuestion!!)
        }
    }

    override val layoutResId = R.layout.fragment_questionnaire

}