package com.example.sachetan.ui.problem_desc

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProblemDescriptionViewModel @Inject constructor() : ViewModel() {
    val problemViewState: ProblemViewState = ProblemViewState()

    fun updateId(id: Int, isSelected: Boolean) {
        when(id) {
            ProblemViewState.BURNT_OUT_ID -> {
                problemViewState._burntOut.value = isSelected
            }

            ProblemViewState.STRESSED_ID -> {
                problemViewState._stressed.value = isSelected
            }

            ProblemViewState.ANXIETY_ID -> {
                problemViewState._anxiety.value = isSelected
            }

            ProblemViewState.CALM_ID -> {
                problemViewState._calm.value = isSelected
            }

            ProblemViewState.SOMETHING_ID -> {
                problemViewState._something.value = isSelected
            }
        }
    }

}