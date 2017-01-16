package com.questionnaire.michaelbabenkov.questionnaire.ui.submit

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitFormInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import rx.Subscriber
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get
import java.util.regex.Pattern

/**
 * Created by michael.babenkov on 16/01/17.
 */
class SubmitPresenter(val submitFormInteractor: SubmitFormInteractor = Injekt.get())
    : SubmitContract.Presenter {

    companion object{
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+")
    }

    override lateinit var view: SubmitContract.View

    override fun start() {
        submitFormInteractor.subscribe(SubmitFormSubscriber())
    }

    override fun stop() {
        submitFormInteractor.unsubscribe()
    }

    override fun onSubmitClicked() {
        if(EMAIL_ADDRESS_PATTERN.matcher(view.getEmail()).matches()) {
            view.showLoading()
            submitFormInteractor.submitForm(
                    view.getName(),
                    view.getEmail(),
                    view.getPhone(),
                    SubmitFormSubscriber())
        } else {
            view.showInvalidEmailMessage()
        }

    }

    inner class SubmitFormSubscriber: Subscriber<SubmitForm>() {
        override fun onCompleted() {

        }

        override fun onNext(form: SubmitForm) {
            view.hideLoading()
            view.submitForm(form)
        }

        override fun onError(e: Throwable?) {
//            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}