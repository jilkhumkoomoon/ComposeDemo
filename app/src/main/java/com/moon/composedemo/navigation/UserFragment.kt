package com.moon.composedemo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moon.composedemo.R
import com.moon.composedemo.databinding.LayoutFragmentUserBinding
import com.moon.plugin.runtime.NavDestination


@NavDestination(type = NavDestination.NavType.Fragment, route = "user_fragment")
class UserFragment : BaseFragment() {
    lateinit var userBinding: LayoutFragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userBinding = LayoutFragmentUserBinding.inflate(inflater, container, false)
        return userBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userBinding.navigateBack.setOnClickListener {
            findNavController().popBackStack(
                R.id.home_fragment,
                inclusive = false,
                saveState = true
            )
        }
    }
}