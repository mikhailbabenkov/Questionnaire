package com.questionnaire.michaelbabenkov.questionnaire.ui.main

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.ResolveSubmitStatusInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 12/01/17.
 */
class MainPresenter(val resolveSubmitStatus: ResolveSubmitStatusInteractor = Injekt.get()) : MainContract.Presenter {

    override lateinit var view: MainContract.View

    override fun start() {
        view.showLoading()
        resolveSubmitStatus.getSubmitState(ResolveSubmitStatusSubscriber())
    }

    override fun stop() {
        resolveSubmitStatus.unsubscribe()
    }

    inner class ResolveSubmitStatusSubscriber: Subscriber<SubmitState>() {

        override fun onCompleted() {

        }

        override fun onNext(state: SubmitState) {
            view.hideLoading()
            view.setSubmitState(state)
        }

        override fun onError(e: Throwable?) {
//            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}