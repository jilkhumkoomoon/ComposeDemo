package com.moon.composedemo.normalnavigation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.moon.composedemo.R
import com.moon.composedemo.databinding.LayoutFragmentHomeBinding

class HomeFragment : BaseFragment() {
    lateinit var homeBinding: LayoutFragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = LayoutFragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    var flag = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        homeBinding.navigateToCategoryFragment.setOnClickListener{
            navController.navigate(NavDeepLinkRequest.Builder.fromUri(Uri.parse("https://com.techme.jetpack/user?phone=124444")).build())
        }

        homeBinding.navigateUp.setOnClickListener{
            navController.clearBackStack(R.id.category_fragment)
        }
    }


}