package com.example.sachetan.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sachetan.domain.usecase.cat.GetRandomCatFactsUseCase
import com.example.sachetan.domain.usecase.user.GetUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val getRandomCatFactsUseCase: GetRandomCatFactsUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel() {

    fun getRandomCatFacts() {
        /*viewModelScope.launch(dispatcherProvider.io) {
            getSensorListUseCase.getSensorList()
                .onFailure {
                    Log.e(TAG, (it as Exception).toString())
                }
                .onSuccess {
                }
        }*/
        //getRandomCatFactsUseCase.getRandomCatFacts()
        viewModelScope.launch(Dispatchers.IO) {
            val resp = getRandomCatFactsUseCase.getRandomCatFacts()
            //Log.d("apple", resp.fact)
            Log.d("apple", resp.toString())
        }
    }

    fun getUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val resp = getUserInfoUseCase.getUserInfo("rohit1@gmail.com")
                //Log.d("apple", resp.fact)
                Log.d("apple", resp.toString())
            } catch (ex: Exception) {
                Log.d("apple", ex.toString())
            }
        }
    }
}