package com.template.app.ui

import android.os.Bundle
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.R
import com.template.app.base.BaseActivity
import com.template.app.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val binding by viewBinding { ActivityMainBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}