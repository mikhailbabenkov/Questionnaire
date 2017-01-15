package com.questionnaire.michaelbabenkov.questionnaire.di

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.QuestionnaireRepository
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.repositories.impl.QuestionnaireRepositoryImpl
import uy.kohesive.injekt.api.InjektModule
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingletonFactory

/**
 * Created by michael.babenkov on 9/01/17.
 */
object RepositoriesModule : InjektModule {

    override fun InjektRegistrar.registerInjectables() {
        addSingletonFactory<QuestionnaireRepository> { QuestionnaireRepositoryImpl() }
    }
}