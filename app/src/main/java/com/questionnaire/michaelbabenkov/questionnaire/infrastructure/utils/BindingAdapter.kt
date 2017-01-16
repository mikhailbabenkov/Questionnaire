package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.utils

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * Created by michael.babenkov on 16/01/17.
 */


object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}