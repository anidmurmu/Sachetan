package com.example.sachetan.ui.onboarding

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sachetan.domain.model.user.UserModel
import com.example.sachetan.domain.usecase.cat.GetRandomCatFactsUseCase
import com.example.sachetan.domain.usecase.user.GetUserInfoUseCase
import com.example.sachetan.domain.usecase.user.SaveUserInfoUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val gson: Gson,
    private val getRandomCatFactsUseCase: GetRandomCatFactsUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val saveUserInfoUseCase: SaveUserInfoUseCase
) : ViewModel() {

    private val _toast: MutableStateFlow<String> =
        MutableStateFlow("")
    val toast: StateFlow<String> = _toast

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
            Log.d("apple5", resp.toString())
        }
    }

    fun getUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val resp = getUserInfoUseCase.getUserInfo("aryan@gmail.com")
                //Log.d("apple", resp.fact)
                Log.d("apple6", resp.toString())
            } catch (ex: Exception) {
                Log.d("apple7", ex.toString())
            }
        }
    }

    fun saveUserInfo(userInfo: UserModel) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val json = gson.toJson(userInfo)
                //val resp = saveUserInfoUseCase.saveUserInfo(json)
                saveUserInfoUseCase.saveUserInfo(userInfo)
                Log.d("apple1", json)
                //Log.d("apple2", resp.toString() ?: "null hai")
                //Log.d("apple", resp.toString())
                _toast.value = "user info saved"
            } catch (ex: Exception) {
                Log.d("apple3", ex.toString())
            }
        }
    }
}