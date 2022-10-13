package com.example.sachetan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.sachetan.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {
    private val viewModel: OnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRandomCatFacts()
    }
}