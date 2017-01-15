package com.questionnaire.michaelbabenkov.questionnaire

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.questionnaire.michaelbabenkov.questionnaire.di.InteractorsModule
import com.questionnaire.michaelbabenkov.questionnaire.di.OtherModule
import com.questionnaire.michaelbabenkov.questionnaire.di.RepositoriesModule
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.InjektMain
import uy.kohesive.injekt.api.InjektRegistrar
import uy.kohesive.injekt.api.addSingleton
import uy.kohesive.injekt.api.addSingletonFactory

/**
 * Created by michael.babenkov on 11/01/17.
 */
class CoreApplication: Application() {
    companion object : InjektMain() {
        override fun InjektRegistrar.registerInjectables() {
            importModule(OtherModule)
            importModule(RepositoriesModule)
            importModule(InteractorsModule)
        }
    }

    override fun onCreate() {
        super.onCreate()
        Injekt.addSingleton<Context>(applicationContext)
        Injekt.addSingletonFactory<SharedPreferences> {
            getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
        }
    }
}