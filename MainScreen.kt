package com.ugl.app

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun MainScreen(activity: Activity) {

    var status by remember { mutableStateOf("Listo para escuchar 🟢") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Habla. Nosotros nos encargamos.", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
                intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE,
                    Locale.getDefault()
                )
                activity.startActivityForResult(intent, 100)
                status = "Escuchando..."
            },
            modifier = Modifier.size(120.dp),
            shape = CircleShape
        ) {
            Text("🎤", fontSize = 32.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(status)
    }
}