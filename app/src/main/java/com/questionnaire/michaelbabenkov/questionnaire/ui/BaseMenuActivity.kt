package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.ActivityDrawerBinding
import android.view.View
import com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared.InvestorType
import com.questionnaire.michaelbabenkov.questionnaire.ui.investorType.InvestorTypeContract
import com.questionnaire.michaelbabenkov.questionnaire.ui.investorType.InvestorTypeFragment
import com.questionnaire.michaelbabenkov.questionnaire.ui.main.MainActivity


/**
 * Created by michael.babenkov on 11/01/17.
 */
abstract class BaseMenuActivity :
        BaseActivity(),
        NavigationView.OnNavigationItemSelectedListener {

    override val layoutResId: Int = R.layout.activity_drawer
    protected lateinit var binding: ActivityDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    override fun onCreateContentView(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, layoutResId)
        setSupportActionBar(toolbar)

        binding.navigationView.apply {
            itemIconTintList = null
            setNavigationItemSelectedListener(this@BaseMenuActivity)
        }
    }

    fun navigateHome(view: View) {
        if (this !is MainActivity) {
            navigator.navigateToMain(this)
        }
    }

    override fun onResume() {
        super.onResume()
        setCheckedItem(selectedItem)
    }

    protected fun setCheckedItem(checkedItem: Int?) {
        if (checkedItem == null) {
            uncheckAllItems()
        } else {
            binding.navigationView.setCheckedItem(checkedItem)
        }
    }

    override fun onBackPressed() {
        val drawer = binding.drawerLayout
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.base_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_action -> {
                openDrawer()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun uncheckAllItems() {
        val size = binding.navigationView.menu.size()
        for (i in 0..size - 1) {
            binding.navigationView.menu.getItem(i).isChecked = false
        }
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.END, true)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_questionnaire -> {
                navigator.navigateToQuestionnaire(this)
            }
            R.id.nav_submit -> {
                navigator.navigateToSubmit(this)
            }
            R.id.nav_balanced -> {
                showInvestorTypeScreen(InvestorType.BALANCED)
            }
            R.id.nav_conservative -> {
                showInvestorTypeScreen(InvestorType.CONSERVATIVE)
                setCheckedItem(R.id.nav_conservative)
            }
            R.id.nav_defensive -> {
                showInvestorTypeScreen(InvestorType.DEFENSIVE)
                setCheckedItem(R.id.nav_defensive)
            }
            R.id.nav_growth -> {
                showInvestorTypeScreen(InvestorType.GROWTH)
                setCheckedItem(R.id.nav_growth)
            }
            R.id.nav_aggressive -> {
                showInvestorTypeScreen(InvestorType.AGGRESSIVE_GROWTH)
                setCheckedItem(R.id.nav_aggressive)
            }
            R.id.nav_balanced_growth -> {
                showInvestorTypeScreen(InvestorType.BALANCED_GROWTH)
                setCheckedItem(R.id.nav_balanced_growth)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.END)
        return true
    }

    private fun  showInvestorTypeScreen(investorType: InvestorType) {
        changeFragment(InvestorTypeFragment.newInstance(investorType))
    }

    abstract val selectedItem: Int?
}