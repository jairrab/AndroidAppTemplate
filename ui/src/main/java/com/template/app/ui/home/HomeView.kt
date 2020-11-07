package com.template.app.ui.home

import android.os.Bundle
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.R
import com.template.app.base.BaseFragment
import com.template.app.databinding.HomeViewBinding
import timber.log.Timber

class HomeView:BaseFragment(R.layout.home_view) {
    private val binding by viewBinding { HomeViewBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.v("onCreate")
    }
}