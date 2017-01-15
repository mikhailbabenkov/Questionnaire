package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.di.ActivityScope
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.navigation.Navigator
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

/**
 * Created by michael.babenkov on 9/01/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    val activityScope by lazy { ActivityScope(this) }
    val navigator: Navigator = Injekt.get()
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateContentView(savedInstanceState)

        toolbar = findViewById(R.id.toolbar) as Toolbar?
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    open protected fun onCreateContentView(savedInstanceState: Bundle?) {
        setContentView(layoutResId)
    }

    protected open val layoutResId: Int = R.layout.activity_toolbar


    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    protected fun changeFragment(fragment: Fragment, containerViewId: Int = R.id.container, addToBackStack: Boolean = false) {
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.replace(containerViewId, fragment).commit()
    }

    protected val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.container)

    protected fun intentToFragmentArguments(intent: Intent?): Bundle {
        val arguments = Bundle()
        if (intent == null) {
            return arguments
        }

        if (intent.data != null) {
            arguments.putParcelable("_uri", intent.data)
        }

        if (intent.extras != null) {
            arguments.putAll(intent.extras)
        }

        return arguments
    }

}