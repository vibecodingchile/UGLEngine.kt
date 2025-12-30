package com.ugl.app

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class AudioManager(context: Context) {

    private val tts = TextToSpeech(context) {
        tts.language = Locale.ENGLISH
    }

    fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}