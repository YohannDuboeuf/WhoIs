package com.example.whois

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.whois.databinding.ActivityQuizBinding
import com.example.whois.viewmodel.QuizViewModel
import com.example.whois.model.Question

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private val viewModel: QuizViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.questions.observe(this) { questions ->
            Log.d("WhoIs", "Questions: $questions") // Affiche la liste des questions
            runOnUiThread {
                updateUI(questions)
            }
        }

        binding.optionA.setOnClickListener {
            checkAnswer(0)
        }

        binding.optionB.setOnClickListener {
            checkAnswer(1)
        }

        binding.optionC.setOnClickListener {
            checkAnswer(2)
        }
    }

    private fun updateUI(questions: List<Question>) {
        val currentQuestion = questions[viewModel.currentQuestionIndex]
        Log.w("WhoIs", "l'id de l'image est => " + currentQuestion.imageResId);

        if (currentQuestion.imageResId != 0) {
            binding.imageView.setImageResource(currentQuestion.imageResId)
        } else {
            Log.e("WhoIs", "Image invalide pour la question: ${0}")
        }

        binding.optionA.text = currentQuestion.options[0]
        binding.optionB.text = currentQuestion.options[1]
        binding.optionC.text = currentQuestion.options[2]
    }

    private fun checkAnswer(selectedIndex: Int) {
        viewModel.checkAnswer(selectedIndex)
        moveToNextQuestion()
    }

    private fun moveToNextQuestion() {
        if (viewModel.currentQuestionIndex >= 5) {
            showEndScreen()
        } else {
            updateUI(viewModel.questions.value ?: return)
        }
    }

    private fun showEndScreen() {
        val score = viewModel.getFinalScore()
        val intent = Intent(this, EndActivity::class.java).apply {
            putExtra("SCORE", score)
        }
        startActivity(intent)
        finish()
    }
}
