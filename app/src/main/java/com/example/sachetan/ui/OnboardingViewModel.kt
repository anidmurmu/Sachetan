package com.example.sachetan.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sachetan.domain.usecase.GetRandomCatFactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val getRandomCatFactsUseCase: GetRandomCatFactsUseCase
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
}