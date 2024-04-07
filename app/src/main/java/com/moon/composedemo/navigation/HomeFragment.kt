package com.moon.composedemo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.moon.composedemo.R
import com.moon.composedemo.databinding.LayoutFragmentHomeBinding
import com.moon.composedemo.navigation.BaseFragment
import com.moon.composedemo.navigation.navigateTo
import com.moon.plugin.runtime.NavDestination

// import com.techme.jetpack.navplugin.runtime.NavDestination


@NavDestination(type = NavDestination.NavType.Fragment, route = "home_fragment", asStarter = true)
class HomeFragment : BaseFragment() {
    lateinit var homeBinding: LayoutFragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = LayoutFragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    var flag = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        homeBinding.navigateToCategoryFragment.setOnClickListener {
            // 对于fragment 类型的路由节点，在 navigate 跳转的时候  使用的fragmentTransaction#replace
            if (flag) {
                navController.navigateTo(
                    "category_fragment", null, NavOptions.Builder().setRestoreState(true).build()
                )
                flag = true
            } else {
                navController.navigate(
                    R.id.category_fragment,
                    null,
                    NavOptions.Builder().setRestoreState(true).build()
                )
            }
            // navController.navigate(NavDeepLinkRequest.Builder.fromUri(Uri.parse("https://com.techme.jetpack/user?phone=124444")).build())
        }

        homeBinding.navigateUp.setOnClickListener {
            navController.clearBackStack(R.id.category_fragment)
        }
    }
}