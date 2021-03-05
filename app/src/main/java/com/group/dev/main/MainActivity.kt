package com.group.dev.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.group.common.base.BaseActivity
import com.group.dev.R


/**
 * 描述:首页
 *
 * author zys
 */
class MainActivity : BaseActivity() {


    private val coordinatorLayout: View by lazy { findViewById(R.id.coordinator_layout) }
    private val bottomNavView: BottomNavigationView by lazy { findViewById(R.id.bottom_nav_view) }


    override fun layoutId(): Int = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    private var lastClickTime = 0L

    override fun onBackPressed() {
        val now = System.currentTimeMillis()
        if (now - lastClickTime > 1000L) {
            lastClickTime = now
            Snackbar.make(coordinatorLayout, "再按一次退出", Snackbar.LENGTH_SHORT)
                .setAction("点一下试试") {
                    super.onBackPressed()
                }
                .show()
        } else {
            super.onBackPressed()
        }
    }
}