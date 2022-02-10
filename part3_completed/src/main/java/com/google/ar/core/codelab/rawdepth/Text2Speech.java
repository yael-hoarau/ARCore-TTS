package com.google.ar.core.codelab.rawdepth;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class Text2Speech {
    TextToSpeech tts;

    public static final Locale FR = Locale.FRANCE;
    public static final Locale US = Locale.US;

    Text2Speech(Context context, Locale langage){
        tts = new TextToSpeech(context, status -> {
            // TODO Auto-generated method stub
            if(status == TextToSpeech.SUCCESS){
                tts.setSpeechRate(1.5f);
                int result=tts.setLanguage(langage);
                if(result==TextToSpeech.LANG_MISSING_DATA ||
                        result==TextToSpeech.LANG_NOT_SUPPORTED){
                    Log.e("error", "This Language is not supported");
                }
            }
            else
                Log.e("error", "Initilization Failed!");
        });
    }

    public void speech(String text){
        if(!tts.isSpeaking())
            tts.speak(text, TextToSpeech.SUCCESS, null, "text");
    }
}
