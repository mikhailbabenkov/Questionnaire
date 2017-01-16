package com.questionnaire.michaelbabenkov.questionnaire.utils

import android.content.Context
import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.mock
import com.questionnaire.michaelbabenkov.questionnaire.di.ActivityScope
import com.questionnaire.michaelbabenkov.questionnaire.di.InteractorsModule
import com.questionnaire.michaelbabenkov.questionnaire.di.OtherModule
import com.questionnaire.michaelbabenkov.questionnaire.di.RepositoriesModule
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors.ExecutionThread
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.InjektMain
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.InjektScope
import uy.kohesive.injekt.api.addSingletonFactory
import uy.kohesive.injekt.api.typeRef
import uy.kohesive.injekt.registry.default.DefaultRegistrar

/**
 * Created by michael.babenkov on 16/01/17.
 */
object SpekHelper {

    lateinit var uiInjekt: ActivityScope

    fun before() {

        uiInjekt = ActivityScope(mock())
        Injekt = InjektScope(DefaultRegistrar())
        object : InjektMain() {
            override fun InjektRegistrar.registerInjectables() {

                val sharedPref: SharedPreferences =  Mockito.mock(SharedPreferences::class.java)
                addSingleton(typeRef<SharedPreferences>(), sharedPref)

                importModule(RepositoriesModule)
                importModule(OtherModule)
                importModule(InteractorsModule)
                addSingleton(typeRef<ExecutionThread>(),TestUiThread())
            }
        }
    }

    fun after() {

    }

}