package com.moon.composedemo

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.fragment.NavHostFragment
import com.moon.composedemo.AppConfig.getBottomBarConfig
import com.moon.composedemo.navigation.AppBottomBar
import com.moon.composedemo.navigation.NavGraphBuilder
import com.moon.composedemo.navigation.switchTab

class NavMainActivity : AppCompatActivity() {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment_container)as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //自定义NavGraphBuilder
        NavGraphBuilder.build(navController, this, R.id.fragment_container)

        val appBottomBar = findViewById<AppBottomBar>(R.id.app_bottom_bar)
        appBottomBar.setOnItemSelectedListener {
            val tab = getBottomBarConfig(this).tabs[it.order]
            navController.switchTab(tab.route)
            !TextUtils.isEmpty(it.title)
        }
    }
}