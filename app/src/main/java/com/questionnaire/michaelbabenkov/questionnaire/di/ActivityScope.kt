package com.questionnaire.michaelbabenkov.questionnaire.di

import android.app.Activity
import com.questionnaire.michaelbabenkov.questionnaire.ui.investorType.InvestorTypeContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.investorType.InvestorTypePresenter
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainPresenter
import com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire.QuestionnaireContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire.QuestionnairePresenter
import com.questionnaire.michaelbabenkov.questionnaire.ui.submit.SubmitContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.submit.SubmitPresenter
import com.questionnaire.michaelbabenkov.questionnaire.ui.summary.SummaryContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.summary.SummaryPresenter
import uy.kohesive.injekt.api.InjektScope
import uy.kohesive.injekt.api.get
import uy.kohesive.injekt.registry.default.DefaultRegistrar

/**
 * Created by michael.babenkov on 9/01/17.
 */
class ActivityScope(val context: Activity): InjektScope(DefaultRegistrar()){
    init {
        //presenters
        addScopedFactory<MainContract.Presenter> { MainPresenter() }
        addScopedFactory<QuestionnaireContract.Presenter> { QuestionnairePresenter() }
        addScopedFactory<SummaryContract.Presenter> { SummaryPresenter() }
        addScopedFactory<InvestorTypeContract.Presenter> { InvestorTypePresenter() }
        addScopedFactory<SubmitContract.Presenter> { SubmitPresenter() }
    }
}