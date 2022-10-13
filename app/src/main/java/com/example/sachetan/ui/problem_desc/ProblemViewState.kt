package com.example.sachetan.ui.problem_desc

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class ProblemViewState {
    companion object {
        const val BURNT_OUT_ID = 1
        const val STRESSED_ID = 2
        const val ANXIETY_ID = 3
        const val CALM_ID = 4
        const val SOMETHING_ID = 5
    }
    val _burntOut: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val burntOut: StateFlow<Boolean>
        get() = _burntOut.asStateFlow()

    val _stressed: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val stressed: StateFlow<Boolean>
        get() = _stressed.asStateFlow()


    val _anxiety: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val anxiety: StateFlow<Boolean>
        get() = _anxiety.asStateFlow()

    val _calm: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val calm: StateFlow<Boolean>
        get() = _calm.asStateFlow()

    val _something: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val something: StateFlow<Boolean>
        get() = _something.asStateFlow()
}