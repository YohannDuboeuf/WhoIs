package com.example.whois.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whois.model.Question
import com.example.whois.R

class QuizViewModel : ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    var currentQuestionIndex = 0
    var score = 0

    val isLoading = MutableLiveData(true)

    init {
        val allQuestions = getQuestions()
        _questions.value = allQuestions.shuffled().take(5) // Mélanger et sélectionner 5 questions
        isLoading.value = false // Fin du chargement
    }

    fun moveToNextQuestion() {
        if (currentQuestionIndex < (_questions.value?.size?.minus(1) ?: 0)) {
            currentQuestionIndex++  // Incrémenter l'index pour passer à la question suivante
        } else {
            // Fin du quiz
        }
    }

    fun checkAnswer(selectedIndex: Int): Boolean {
        val currentQuestion = _questions.value?.get(currentQuestionIndex)

        Log.d("QuizViewModel", "Question ${currentQuestion?.correctAnswerIndex}, Selected: $selectedIndex")

        return if (currentQuestion != null && currentQuestion.correctAnswerIndex == selectedIndex) {
            score++
            true
        } else {
            false
        }
    }

    fun getFinalScore(): Int {
        return score
    }

    fun getRandomNames(excludedName: String, allNames: List<String>): List<String> {
        val remainingNames = allNames.filter { it != excludedName }
        return remainingNames.shuffled().take(2)
    }

    fun getQuestions(): List<Question> {
        val allNames = listOf("Benoit", "Quentin", "Flo", "Remi", "Nico", "Martin", "Jude", "Jeremy", "Hugo", "Francois", "Denis", "Coline")

        return listOf(
            createQuestion(R.drawable.team_benoit, "Benoit", allNames),
            createQuestion(R.drawable.team_remi2, "Remi", allNames),
            createQuestion(R.drawable.team_remi, "Remi", allNames),
            createQuestion(R.drawable.team_q3, "Quentin", allNames),
            createQuestion(R.drawable.team_q2, "Quentin", allNames),
            createQuestion(R.drawable.team_nico, "Nico", allNames),
            createQuestion(R.drawable.team_martin, "Martin", allNames),
            createQuestion(R.drawable.team_jude, "Jude", allNames),
            createQuestion(R.drawable.team_jeremy, "Jeremy", allNames),
            createQuestion(R.drawable.team_hugo, "Hugo", allNames),
            createQuestion(R.drawable.team_francois, "Francois", allNames),
            createQuestion(R.drawable.team_flo, "Flo", allNames),
            createQuestion(R.drawable.team_denis, "Denis", allNames),
            createQuestion(R.drawable.team_coline, "Coline", allNames),
            createQuestion(R.drawable.team_tom2, "Tom", allNames)
        )
    }

    fun createQuestion(imageResId: Int, correctName: String, allNames: List<String>): Question {
        val randomNames = getRandomNames(correctName, allNames)

        val answers = listOf(correctName) + randomNames
        val shuffledAnswers = answers.shuffled()

        val correctAnswerIndex = shuffledAnswers.indexOf(correctName)

        return Question(imageResId, shuffledAnswers, correctAnswerIndex)
    }
}
