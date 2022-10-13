package com.example.sachetan.ui.problem_desc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sachetan.databinding.ActivityProblemDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProblemDescriptionActivity : ComponentActivity() {

    private val viewModel: ProblemDescriptionViewModel by viewModels()
    //private lateinit var binding: ActivityProblemDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = ActivityProblemDescriptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/

        setContent {
            ProblemDescriptionScreen(viewModel)
        }
    }
}