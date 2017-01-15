package com.questionnaire.michaelbabenkov.questionnaire.ui

/**
 * Created by michael.babenkov on 12/01/17.
 */
interface BasePresenter<T> {
    var view : T
    fun start()
    fun stop()
}