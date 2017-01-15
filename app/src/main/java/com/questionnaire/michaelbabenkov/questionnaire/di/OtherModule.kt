package com.questionnaire.michaelbabenkov.questionnaire.di

import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.JobExecutor
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.RxThread
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation.Navigator
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation.NavigatorImpl
import uy.kohesive.injekt.api.InjektModule
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingletonFactory
import java.util.concurrent.Executor

/**
 * Created by michael.babenkov on 9/01/17.
 */
object OtherModule : InjektModule {

    override fun InjektRegistrar.registerInjectables() {

        addSingletonFactory <Executor> {
            JobExecutor()
        }

        addSingletonFactory<ExecutionThread> {
            RxThread()
        }


        addSingletonFactory<Navigator> {
            NavigatorImpl()
        }

    }
}