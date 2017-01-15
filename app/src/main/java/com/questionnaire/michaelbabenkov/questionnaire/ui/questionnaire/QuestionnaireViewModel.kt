package com.questionnaire.michaelbabenkov.questionnaire.ui.questionnaire

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 13/01/17.
 */
class QuestionnaireViewModel: BaseObservable() {

    @get:Bindable
    var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @get:Bindable
    var question: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.question)
        }
}