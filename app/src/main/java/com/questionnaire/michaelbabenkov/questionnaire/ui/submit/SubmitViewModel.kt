package com.questionnaire.michaelbabenkov.questionnaire.ui.submit

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcel
import android.os.Parcelable
import com.questionnaire.michaelbabenkov.questionnaire.BR

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SubmitViewModel() : BaseObservable(), Parcelable {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<SubmitViewModel> {
            override fun newArray(size: Int): Array<SubmitViewModel?> {
                return arrayOfNulls(size)
            }

            override fun createFromParcel(parcel: Parcel): SubmitViewModel {
                return SubmitViewModel(parcel)
            }
        }
    }

    constructor(parcel: Parcel) : this() {
        email = parcel.readString()
        name = parcel.readString()
        phone = parcel.readString()
        emailError = parcel.readString()
        isErrorEnabled = parcel.readInt() == 1
        loading = parcel.readInt() == 1
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeString(emailError)
        parcel.writeInt(if (isErrorEnabled) 1 else 0)
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

    @get:Bindable
    var email: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var phone: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.phone)
        }

    @get:Bindable
    var emailError: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.emailError)
            isErrorEnabled = value.isNotBlank()
        }

    @get:Bindable
    var isErrorEnabled = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorEnabled)
        }
}