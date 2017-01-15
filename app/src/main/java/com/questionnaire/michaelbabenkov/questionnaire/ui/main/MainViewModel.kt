package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcel
import android.os.Parcelable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 12/01/17.
 */
class MainViewModel(): BaseObservable(), Parcelable {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<MainViewModel> {
            override fun newArray(size: Int): Array<MainViewModel?> {
                return arrayOfNulls(size)
            }

            override fun createFromParcel(parcel: Parcel): MainViewModel {
                return MainViewModel(parcel)
            }
        }
    }

    constructor(parcel: Parcel) : this() {
        loading = parcel.readInt() == 1
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(if (loading) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    @get:Bindable
    var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }
}