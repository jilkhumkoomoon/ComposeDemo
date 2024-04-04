package com.moon.composedemo.navigation

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moon.composedemo.AppConfig
import com.moon.composedemo.R

/**
 * 注解的含义：https://www.jianshu.com/p/0d312fac3a65
 * */
class AppBottomBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
): BottomNavigationView(context,attrs) {
    private val sIcons = intArrayOf(
        R.drawable.icon_tab_main,
        R.drawable.icon_tab_category,
        R.drawable.icon_tab_publish,
        R.drawable.icon_tab_tags,
        R.drawable.icon_tab_user
    )

    init {
        val config = AppConfig.getBottomBarConfig(context)
        val states = arrayOfNulls<IntArray>(2)
        states[0] = IntArray(1) { android.R.attr.state_selected }
        states[1] = intArrayOf()

        val colors =
            intArrayOf(Color.parseColor(config.activeColor), Color.parseColor(config.inActiveColor))
        val colorStateList = ColorStateList(states, colors)

        itemTextColor = colorStateList
        itemIconTintList = colorStateList
        //LABEL_VISIBILITY_LABELED:设置按钮的文本为一直显示模式
        //LABEL_VISIBILITY_AUTO:当按钮个数小于三个时一直显示，或者当按钮个数大于3个且小于5个时，被选中的那个按钮文本才会显示
        //LABEL_VISIBILITY_SELECTED：只有被选中的那个按钮的文本才会显示
        //LABEL_VISIBILITY_UNLABELED:所有的按钮文本都不显示
        labelVisibilityMode = LABEL_VISIBILITY_LABELED

        val tabs = config.tabs
        tabs.forEachIndexed { index, tab ->
            if (!tab.enable) return@forEachIndexed
            val menuItem = menu.add(0, tab.route.hashCode(), index, tab.title)
            menuItem.setIcon(sIcons[index])
        }
    }
}