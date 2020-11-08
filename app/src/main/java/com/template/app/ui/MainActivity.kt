package com.template.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.github.jairrab.androidutilities.eventobserver.EventObserver
import com.github.jairrab.androidutilities.utility.AndroidUtility
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.base.BaseActivity
import com.template.app.databinding.ActivityMainBinding
import com.template.app.viewmodel.main.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    @Inject lateinit var androidUtility: AndroidUtility

    private val binding by viewBinding { ActivityMainBinding.inflate(it) }
    private val activityViewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        activityViewModel.activityViewModelSetupLd.observe(this, EventObserver {
            val text = "Activity viewModel setup is running OK"
            Timber.v(text)
            androidUtility.showToast(text)
        })
    }
}