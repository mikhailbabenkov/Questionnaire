package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcel
import android.os.Parcelable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 12/01/17.
 */
class MainViewModel: BaseObservable() {

    @get:Bindable
    var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }
}