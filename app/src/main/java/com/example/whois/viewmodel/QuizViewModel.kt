package com.example.whois.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whois.model.Question
import com.example.whois.R

class QuizViewModel : ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    var currentQuestionIndex = 0
    private var score = 0

    init {
        val allQuestions = getQuestions()
        _questions.value = allQuestions.shuffled().take(5) // pool de questions aléatoire (5 c'est pas mal)
    }

    fun checkAnswer(selectedIndex: Int) {
        val currentQuestion = _questions.value?.get(currentQuestionIndex)
        if (currentQuestion != null && selectedIndex == currentQuestion.correctAnswerIndex) {
            score++
        }
        currentQuestionIndex++
    }

    fun getFinalScore(): Int {
        return score
    }

    fun getRandomNames(excludedName: String, allNames: List<String>): List<String> {
        val remainingNames = allNames.filter { it != excludedName }
        return remainingNames.shuffled().take(2) // Choisir deux prénoms au hasard parmi ceux restants
    }

    fun getQuestions(): List<Question> {
        // Liste des prénoms
        val allNames = listOf("Benoit", "Quentin", "Flo", "Remi", "Nico", "Martin", "Jude", "Jeremy", "Hugo", "Francois", "Denis", "Coline")

        return listOf(
            createQuestion(R.drawable.team_benoit, "Benoit", allNames), // Benoit -> Benoit
            createQuestion(R.drawable.team_remi2, "Remi", allNames),   // Remi2 -> Remi
            createQuestion(R.drawable.team_remi, "Remi", allNames),    // Remi -> Remi
            createQuestion(R.drawable.team_q3, "Quentin", allNames),  // Q3 -> Quentin
            createQuestion(R.drawable.team_q2, "Quentin", allNames),  // Q2 -> Quentin
            createQuestion(R.drawable.team_nico, "Nico", allNames),   // Nico -> Nico
            createQuestion(R.drawable.team_martin, "Martin", allNames), // Martin -> Martin
            createQuestion(R.drawable.team_jude, "Jude", allNames),   // Jude -> Jude
            createQuestion(R.drawable.team_jeremy, "Jeremy", allNames), // Jeremy -> Jeremy
            createQuestion(R.drawable.team_hugo, "Hugo", allNames),  // Hugo -> Hugo
            createQuestion(R.drawable.team_francois, "Francois", allNames), // Francois -> Francois
            createQuestion(R.drawable.team_flo, "Flo", allNames),    // Flo -> Flo
            createQuestion(R.drawable.team_denis, "Denis", allNames), // Denis -> Denis
            createQuestion(R.drawable.team_coline, "Coline", allNames), // Coline -> Coline
            createQuestion(R.drawable.team_tom2, "Tom", allNames) // Tom -> Quentin
        )
    }

    fun createQuestion(imageResId: Int, correctName: String, allNames: List<String>): Question {
        val randomNames = getRandomNames(correctName, allNames)

        val answers = listOf(correctName) + randomNames
        val shuffledAnswers = answers.shuffled()  // Mélanger les réponses

        val correctAnswerIndex = shuffledAnswers.indexOf(correctName)

        return Question(imageResId, shuffledAnswers, correctAnswerIndex)
    }
}