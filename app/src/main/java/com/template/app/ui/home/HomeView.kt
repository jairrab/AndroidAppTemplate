package com.template.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.github.jairrab.androidutilities.utility.AndroidUtility
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.R
import com.template.app.base.BaseFragment
import com.template.app.databinding.HomeViewBinding
import com.template.app.viewmodel.main.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject

@AndroidEntryPoint
@WithFragmentBindings
class HomeView : BaseFragment(R.layout.home_view) {
    @Inject lateinit var androidUtility: AndroidUtility

    private val binding by viewBinding { HomeViewBinding.bind(it) }
    private val activityViewModel by activityViewModels<ActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hiltSetupCheck.setOnClickListener {
            androidUtility.showToast("Hilt setup is working")
        }

        binding.viewModelCheck.setOnClickListener {
            activityViewModel.checkActivityViewModelSetup()
        }

        binding.retrofitCheck.setOnClickListener {
            activityViewModel.checkRetrofit("jairrab")
        }

        binding.roomCheck.setOnClickListener {
            activityViewModel.checkRoom("jairrab")
        }

        activityViewModel.result.observe(viewLifecycleOwner) {
            androidUtility.showToast(it)
        }
    }
}