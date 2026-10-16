package com.dgym.app.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFF0B0B0D)), // negro mate
    contentAlignment = Alignment.Center
  ) {
    // Animación de zoom
    var startAnim by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
      targetValue = if (startAnim) 1.0f else 0.8f,
      animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)
    )

    LaunchedEffect(Unit) {
      startAnim = true
      // esperar para la secuencia (ej: 2.5s total como pediste)
      delay(2500)
      onAnimationFinished()
    }

    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Image(
        painter = painterResource(id = com.dgym.app.R.drawable.logo_dgym), // sustituir por tu logo
        contentDescription = "D GYM logo",
        modifier = Modifier
          .size(220.dp)
          .scale(scale)
          .graphicsLayer {
            // pequeño giro o elevación si quieres
            shadowElevation = 8f
          }
      )

      Spacer(modifier = Modifier.height(16.dp))

      Text(
        text = "FUERZA. DISCIPLINA. EVOLUCIÓN.",
        color = Color.White
      )
    }

    // Aquí se puede superponer un Canvas para el "destello rojo" que recorra el contorno del logo.
    // Lo implementaré con Canvas y animación de stroke cuando incorpore tu SVG.
  }
}
