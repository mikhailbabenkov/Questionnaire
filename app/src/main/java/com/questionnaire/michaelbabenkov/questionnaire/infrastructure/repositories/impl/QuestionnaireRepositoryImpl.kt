package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.impl

import android.content.SharedPreferences
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.JobExecutor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.RxThread
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model.SubmitForm
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.QuestionnaireRepository
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import rx.Observable
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get
import uy.kohesive.injekt.api.typeRef
import java.util.concurrent.TimeUnit

/**
 * Created by michael.babenkov on 12/01/17.
 */
class QuestionnaireRepositoryImpl(
        private val sharedPreferences: SharedPreferences = Injekt.get(),
        private val executionThread: ExecutionThread = Injekt.get()
) : QuestionnaireRepository {

    companion object{
        val SUBMITED_PREF = "pref-submitted"
        val SUBMITED_POINTS = "pref-submitted-points"
    }

    override fun getSubmitState(): Observable<SubmitState> {
        val observable = Observable.create<SubmitState> { subscriber ->
            val isSubmitted = sharedPreferences.getBoolean(SUBMITED_PREF, false)
            val submittedPoints = sharedPreferences.getInt(SUBMITED_POINTS, 0)

            val state = when {
                (isSubmitted && submittedPoints > 0) -> SubmitState.SUBMITTED
                (!isSubmitted && submittedPoints == 0) -> SubmitState.DISABLED
                else -> SubmitState.ENABLED
            }

            subscriber.onNext(state)
            subscriber.onCompleted()
        }

        return observable
    }

    override fun submitPoints(points: Int): Observable<Int> {
        val observable = Observable.create<Int> { subscriber ->
            sharedPreferences.edit().putBoolean(SUBMITED_PREF, false).apply()
            sharedPreferences.edit().putInt(SUBMITED_POINTS, points).apply()
            subscriber.onNext(points)
            subscriber.onCompleted()
        }
        return observable.delay(
                Injekt.getKeyedInstanceOrElse(Long::class.java, "test", 10000L),
                TimeUnit.MILLISECONDS, executionThread.getSubscribeThread())
    }

    override fun submitForm(name: String, email: String, phone: String): Observable<SubmitForm> {
        val observable = Observable.create<SubmitForm> { subscriber ->
            val pointsToSubmit = sharedPreferences.getInt(SUBMITED_POINTS, 0)
            sharedPreferences.edit().putBoolean(SUBMITED_PREF, true).apply()
            subscriber.onNext(
                    SubmitForm(name = name, email = email, phone = phone, points = pointsToSubmit))
            subscriber.onCompleted()
        }
        return observable.delay(1000, TimeUnit.MILLISECONDS)
    }
}