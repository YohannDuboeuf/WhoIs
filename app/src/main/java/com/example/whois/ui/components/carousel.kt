package com.example.whois.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.constraintlayout.helper.widget.Carousel
import kotlinx.coroutines.delay
import com.example.whois.R // Pour accéder aux ressources comme R.drawable.image1

// Données d'images avec leur description
data class ImageItem(
    val drawableResId: Int,
    val description: String
)

// Liste des images avec leurs descriptions
val alignYourBodyData = listOf(
    ImageItem(R.drawable.team_benoit, "Benoit"),
    ImageItem(R.drawable.team_remi2, "Remi"),
    ImageItem(R.drawable.team_remi, "Remi"),
    ImageItem(R.drawable.team_q3, "Quentin"),
    ImageItem(R.drawable.team_q2, "Quentin"),
    ImageItem(R.drawable.team_nico, "Nico"),
    ImageItem(R.drawable.team_martin, "Martin"),
    ImageItem(R.drawable.team_jude, "Jude"),
    ImageItem(R.drawable.team_jeremy, "Jeremy"),
    ImageItem(R.drawable.team_hugo, "Hugo"),
    ImageItem(R.drawable.team_francois, "Francois"),
    ImageItem(R.drawable.team_flo, "Flo"),
    ImageItem(R.drawable.team_denis, "Denis"),
    ImageItem(R.drawable.team_coline, "Coline"),
    ImageItem(R.drawable.team_tom2, "Tom"),
)

@Composable
fun Carousel(
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        var currentIndex = 0
        val size = alignYourBodyData.size

        // Faire défiler en boucle infinie
        while (true) {
            delay(500)

            listState.animateScrollToItem(currentIndex)
            currentIndex = (currentIndex + 1) % size
        }
    }

    LazyRow(
        modifier = modifier,
        state = listState
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawableResId, item.description)
        }
    }
}

@Composable
fun AlignYourBodyElement(drawableResId: Int, description: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawableResId),
            contentDescription = description,
            modifier = Modifier
                .size(160.dp)
                .padding(8.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
