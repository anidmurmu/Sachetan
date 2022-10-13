package com.example.sachetan.ui.problem_desc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sachetan.R
import com.example.sachetan.ui.onboarding.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProblemDescriptionActivity : ComponentActivity() {

    private val viewModel: ProblemDescriptionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProblemDescriptionScreen(viewModel, onSubmit = {
                val list = getSelectedList()
                Log.d("apple12", list.toString())
                OnBoardingActivity.startActivity(this@ProblemDescriptionActivity, list)
            })
        }
    }
    
    private fun getSelectedList(): ArrayList<String> {
        val list = arrayListOf<String>()
        if(viewModel.problemViewState.burntOut.value) {
            list.add(resources.getString(R.string.burnt_out_msg))
        }
        if(viewModel.problemViewState.stressed.value) {
            list.add(resources.getString(R.string.stressed_msg))
        }
        if(viewModel.problemViewState.anxiety.value) {
            list.add(resources.getString(R.string.anxiety_msg))
        }
        if(viewModel.problemViewState.calm.value) {
            list.add(resources.getString(R.string.calm_msg))
        }
        if(viewModel.problemViewState.something.value) {
            list.add(resources.getString(R.string.something_msg))
        }
        return list
    }
}