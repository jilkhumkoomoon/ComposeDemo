@file:Suppress("DEPRECATION")
package com.moon.plugin

import com.android.build.gradle.BaseExtension
import com.moon.plugin.runtime.NavData
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin

class NavPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("NavPlugin apply...")

        val appPlugin = project.plugins.findPlugin(ApplicationPlugin::class.java)
        assert(appPlugin == null) {
            throw GradleException("NavPlugin can only be applied to app module")
        }

        //注册插件的固定方式，采用project.extensions的registerTransform()函数进行注册
        val extensions = project.extensions.findByType(BaseExtension::class.java)
        extensions?.registerTransform(NavTransform(project))
    }
}