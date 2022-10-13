package com.example.sachetan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.sachetan.databinding.ActivityOnboardingBinding
import com.example.sachetan.domain.model.user.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private val viewModel: OnboardingViewModel by viewModels()
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //viewModel.getRandomCatFacts()
        viewModel.getUserInfo()

        binding.btnSubmit.setOnClickListener {
            val userDetails = getUserDetails(binding)
            Log.d("apple", userDetails.toString())
        }
    }



    private fun getUserDetails(binding: ActivityOnboardingBinding): UserModel {
        val name = binding.tietName.text.toString()
        val gender = binding.tietGender.text.toString()
        val phone = binding.tietPhone.text.toString()
        val email = binding.tietEmail.text.toString()
        val age = binding.tietAge.text.toString()
        val emergencyName = binding.tietEmergencyName.text.toString()
        val emergencyPhoneNum = binding.tietEmergencyPhone.text.toString()
        val isProfessional = true

        return UserModel(
            name = name,
            gender = gender,
            phoneNum = phone,
            emailId = email,
            age = age,
            emergencyName = emergencyName,
            emergencyPhoneNum = emergencyPhoneNum,
            isProfessional = isProfessional
        )
    }
}