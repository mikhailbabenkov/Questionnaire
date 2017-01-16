package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainContract
import com.questionnaire.michaelbabenkov.questionnaire.utils.SpekHelper
import org.jetbrains.spek.api.Spek
import org.mockito.Mockito
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 16/01/17.
 */
class MainPresenterTest: Spek({

    var presenter: MainContract.Presenter = mock()
    var mockView: MainContract.View = mock()
    var sharedPref: SharedPreferences = mock()

    beforeEach {
        SpekHelper.before()
        mockView = mock()
        presenter = SpekHelper.uiInjekt.get()
        sharedPref = Injekt.get()
        presenter.view = mockView
    }

    describe("screen is opened first time") {

        beforeEach {
            Mockito.`when`(sharedPref.getBoolean(any(), any())).then { false }
            Mockito.`when`(sharedPref.getInt(any(), any())).then { 0 }
            presenter.start()
        }

        it("should show loading first") {
            verify(mockView).showLoading()
        }

        it("should show hide loading") {
            verify(mockView).hideLoading()
        }

        it("should show disabled state") {
            verify(mockView).setSubmitState(SubmitState.DISABLED)
        }
    }

    describe("screen is opened not the first time") {

        on("after finished questionnaire") {
            beforeEach {
                Mockito.`when`(sharedPref.getBoolean(any(), any())).then { false }
                Mockito.`when`(sharedPref.getInt(any(), any())).then { 12 }
                presenter.start()
            }

            it("should show submit state") {
                verify(mockView).setSubmitState(SubmitState.ENABLED)
            }
        }

        on("after submission sent") {
            beforeEach {

                Mockito.`when`(sharedPref.getBoolean(any(), any())).then { true }
                Mockito.`when`(sharedPref.getInt(any(), any())).then { 12 }
                presenter.start()
            }

            it("should show submit state") {
                verify(mockView).setSubmitState(SubmitState.SUBMITTED)
            }
        }

    }


    afterEach {
        SpekHelper.after()
    }

})