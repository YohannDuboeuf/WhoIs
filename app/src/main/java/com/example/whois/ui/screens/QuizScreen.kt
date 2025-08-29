package com.example.whois.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whois.viewmodel.QuizViewModel

@Composable
fun QuizScreen(viewModel: QuizViewModel, onRestartQuiz: () -> Unit) {
    val context = LocalContext.current
    val questionIndex = viewModel.currentQuestionIndex.observeAsState(0)
    val question = viewModel.questions.value?.getOrNull(questionIndex.value)
    val isQuizFinished = viewModel.isQuizFinished.observeAsState(false)

    if (viewModel.isLoading.value == true) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else if (isQuizFinished.value) {
        // Affiche l'écran de fin avec le score et le bouton pour redémarrer le quiz
        EndScreen(score = viewModel.getFinalScore(), onRestartQuiz = {
            viewModel.resetQuiz() // Réinitialiser le quiz
            onRestartQuiz() // Exécute la fonction pour redémarrer l'activité
        })
    } else if (question != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Question ${questionIndex.value + 1}",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = question.imageResId),
                contentDescription = "Question Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            question.options.forEachIndexed { index, option ->
                Button(
                    onClick = {
                        val isCorrect = viewModel.checkAnswer(index)
                        val resultMessage = if (isCorrect) {
                            "Bonne réponse!"
                        } else {
                            "Mauvaise réponse!"
                        }

                        Toast.makeText(context, "$resultMessage: $option", Toast.LENGTH_SHORT).show()

                        // Passe à la question suivante
                        viewModel.moveToNextQuestion()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = option)
                }
            }
        }
    } else {
        Text(text = "Fin du quiz ou erreur de données.", fontSize = 24.sp)
    }
}
