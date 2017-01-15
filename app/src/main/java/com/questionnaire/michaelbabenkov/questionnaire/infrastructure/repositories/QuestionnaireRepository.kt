package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.SubmitState
import rx.Observable

/**
 * Created by michael.babenkov on 9/01/17.
 */
interface QuestionnaireRepository {
    fun getSubmitState(): Observable<SubmitState>
    fun submitPoints(points: Int): Observable<Int>
}