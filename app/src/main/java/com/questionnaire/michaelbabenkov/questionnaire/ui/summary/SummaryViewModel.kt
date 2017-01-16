package com.questionnaire.michaelbabenkov.questionnaire.ui.summary

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SummaryViewModel: BaseObservable() {

    @get:Bindable
    var points: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.points)
        }
    @get:Bindable
    var investorType: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.investorType)
        }
}