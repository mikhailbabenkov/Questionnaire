package com.questionnaire.michaelbabenkov.questionnaire.di

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.ResolveSubmitStatusInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitFormInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.SubmitPointsInteractor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl.ResolveSubmitStatusInteractorImpl
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl.SubmitFormInteractorImpl
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.interactors.impl.SubmitPointsInteractorImpl
import uy.kohesive.injekt.api.InjektModule
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingletonFactory

/**
 * Created by michael.babenkov on 9/01/17.
 */
object InteractorsModule : InjektModule {

    override fun InjektRegistrar.registerInjectables() {
        addSingletonFactory<ResolveSubmitStatusInteractor> { ResolveSubmitStatusInteractorImpl() }
        addSingletonFactory<SubmitPointsInteractor> { SubmitPointsInteractorImpl() }
        addSingletonFactory<SubmitFormInteractor> { SubmitFormInteractorImpl() }
    }
}