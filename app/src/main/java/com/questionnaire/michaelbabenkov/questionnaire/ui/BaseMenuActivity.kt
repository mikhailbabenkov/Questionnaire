package com.questionnaire.michaelbabenkov.questionnaire.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import com.questionnaire.michaelbabenkov.questionnaire.R
import com.questionnaire.michaelbabenkov.questionnaire.databinding.ActivityDrawerBinding
import android.view.MenuInflater
import android.databinding.adapters.CompoundButtonBindingAdapter.setChecked


/**
 * Created by michael.babenkov on 11/01/17.
 */
abstract class BaseMenuActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

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

    override fun onResume() {
        super.onResume()
        if (selectedItem == null) {
            uncheckAllItems()
        } else {
            binding.navigationView.setCheckedItem(selectedItem as Int)
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
            R.id.nav_questionnaire -> navigator.navigateToQuestionnaire(this)
        }
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        binding.drawerLayout.closeDrawer(GravityCompat.END)
        return true
    }

    abstract val selectedItem: Int?
}