package com.moon.plugin.runtime

data class NavData (
    val route: String,
    val className: String,
    val asStarter: Boolean,
    val type: NavDestination.NavType
    )