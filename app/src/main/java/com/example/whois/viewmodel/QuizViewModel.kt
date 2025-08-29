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

    private val _currentQuestionIndex = MutableLiveData(0)
    val currentQuestionIndex: LiveData<Int> = _currentQuestionIndex

    private var _score = 0
    val score: Int get() = _score

    val isLoading = MutableLiveData(true)

    private val _isQuizFinished = MutableLiveData(false) // Nouvel état pour savoir si le quiz est terminé
    val isQuizFinished: LiveData<Boolean> = _isQuizFinished

    init {
        val allQuestions = getQuestions()
        _questions.value = allQuestions.shuffled().take(5) // Mélange les questions et prend 5
        isLoading.value = false
    }

    // Fonction pour passer à la question suivante
    fun moveToNextQuestion() {
        val currentIndex = _currentQuestionIndex.value ?: 0
        if (currentIndex < (_questions.value?.size?.minus(1) ?: 0)) {
            _currentQuestionIndex.value = currentIndex + 1
        } else {
            _isQuizFinished.value = true // Le quiz est terminé
        }
    }

    // Fonction pour vérifier si la réponse sélectionnée est correcte
    fun checkAnswer(selectedIndex: Int): Boolean {
        val currentQuestion = _questions.value?.get(_currentQuestionIndex.value ?: 0)
        return if (currentQuestion != null && currentQuestion.correctAnswerIndex == selectedIndex) {
            _score++
            true
        } else {
            false
        }
    }

    // Retourne le score final
    fun getFinalScore(): Int {
        return _score
    }

    // Réinitialiser le quiz pour recommencer
    fun resetQuiz() {
        _currentQuestionIndex.value = 0
        _score = 0
        _isQuizFinished.value = false
        val allQuestions = getQuestions()
        _questions.value = allQuestions.shuffled().take(5) // Mélange les questions et en prend 5 au hasard
    }

    // Génère une liste de noms aléatoires pour les réponses
    fun getRandomNames(excludedName: String, allNames: List<String>): List<String> {
        val remainingNames = allNames.filter { it != excludedName }
        return remainingNames.shuffled().take(2)
    }

    // Crée une question avec une image, une réponse correcte et des réponses aléatoires
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

    // Crée une question avec une image, un nom correct et une liste de réponses mélangées
    fun createQuestion(imageResId: Int, correctName: String, allNames: List<String>): Question {
        val randomNames = getRandomNames(correctName, allNames)

        val answers = listOf(correctName) + randomNames
        val shuffledAnswers = answers.shuffled()

        val correctAnswerIndex = shuffledAnswers.indexOf(correctName)

        return Question(imageResId, shuffledAnswers, correctAnswerIndex)
    }
}
