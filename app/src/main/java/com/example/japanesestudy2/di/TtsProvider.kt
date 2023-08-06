package com.example.japanesestudy2.di

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TtsProvider @Inject constructor(
    @ApplicationContext val context: Context
): TextToSpeech.OnInitListener {
    private var tts: TextToSpeech = TextToSpeech(context, this)
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.JAPANESE)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language not supported!")
            }
        }
    }

    fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }
}