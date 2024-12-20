package com.moon.composedemo.normalnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moon.composedemo.R
import com.moon.composedemo.databinding.LayoutFragmentCategoryBinding

class CategoryFragment : BaseFragment() {

    private lateinit var categoryBinding: LayoutFragmentCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate: $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryBinding = LayoutFragmentCategoryBinding.inflate(inflater,container,false)
        return categoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryBinding.navigateToTagsFragment.setOnClickListener{
            findNavController().navigate(R.id.tags_fragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("outState","我是categoryFragment")
    }

}