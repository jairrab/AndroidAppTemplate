package com.template.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.R
import com.template.app.base.BaseFragment
import com.template.app.databinding.HomeViewBinding
import com.template.app.viewmodel.main.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class HomeView : BaseFragment(R.layout.home_view) {
    private val binding by viewBinding { HomeViewBinding.bind(it) }
    private val activityViewModel by activityViewModels<ActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            activityViewModel.checkSetup()
        }
    }
}