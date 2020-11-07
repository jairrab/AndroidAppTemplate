package com.template.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.jairrab.viewbindingutility.viewBinding
import com.template.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding { ActivityMainBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}