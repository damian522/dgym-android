package com.dgym.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ModeratorLoginScreen(onLogin: (String, String) -> Unit, onBack: () -> Unit) {
  var password by remember { mutableStateOf("") }
  var showPassword by remember { mutableStateOf(false) }
  var error by remember { mutableStateOf<String?>(null) }

  // Demo credential (REMOVE for production)
  val demoEmail = "djyc2010foxy@gmail.com"
  val demoPassword = "TempPass#1234"

  Column(modifier = Modifier
    .fillMaxSize()
    .padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    // Logo already on previous screen; keep minimal here
    Text("ACCESO DE MODERADOR", style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.height(24.dp))

    OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Contraseña") }, visualTransformation = if (showPassword) androidx.compose.ui.text.input.VisualTransformation.None else PasswordVisualTransformation(), trailingIcon = {
      IconButton(onClick = { showPassword = !showPassword }) {
        Icon(imageVector = androidx.compose.material.icons.Icons.Default.Visibility, contentDescription = if (showPassword) "Ocultar" else "Mostrar")
      }
    })

    Spacer(modifier = Modifier.height(16.dp))

    if (error != null) {
      Text(error!!, color = MaterialTheme.colorScheme.error)
      Spacer(modifier = Modifier.height(8.dp))
    }

    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      Button(onClick = {
        // Demo authentication: only for testing. In production this should use secure server-side auth (Firebase).
        if (password == demoPassword) {
          error = null
          onLogin(demoEmail, password)
        } else {
          error = "Credenciales incorrectas (demo)."
        }
      }) {
        Text("INGRESAR")
      }

      OutlinedButton(onClick = onBack) {
        Text("VOLVER")
      }
    }

    Spacer(modifier = Modifier.height(16.dp))
    // Inform the user about demo credentials (visible in-app for testing)
    Text("(Demo) Email: $demoEmail", style = MaterialTheme.typography.bodySmall)
    Text("(Demo) Contraseña: $demoPassword", style = MaterialTheme.typography.bodySmall)
  }
}
