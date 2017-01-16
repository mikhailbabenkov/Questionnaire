package com.questionnaire.michaelbabenkov.questionnaire.ui.investorType

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 16/01/17.
 */
class InvestorTypeViewModel: BaseObservable() {

    @get:Bindable
    var description: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }
    @get:Bindable
    var imageRes: Int? = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageRes)
        }
}