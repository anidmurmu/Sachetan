package com.example.sachetan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
            viewModel.saveUserInfo(userDetails)
            clearFields(binding)
            Log.d("apple4", userDetails.toString())
        }

        lifecycleScope.launchWhenResumed {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.toast.collect {
                    Toast.makeText(this@OnboardingActivity, it, Toast.LENGTH_SHORT)
                }
            }
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
        val isProfessional = binding.cbIsProfessional.isChecked

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

    private fun clearFields(binding: ActivityOnboardingBinding) {
        binding.tietName.text?.clear()
        binding.tietGender.text?.clear()
        binding.tietPhone.text?.clear()
        binding.tietEmail.text?.clear()
        binding.tietAge.text?.clear()
        binding.tietEmergencyName.text?.clear()
        binding.tietEmergencyPhone.text?.clear()
        binding.cbIsProfessional.isChecked = false
    }

}