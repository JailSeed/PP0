package com.jailseed.lab3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click_audio_btn(view: View) {
        val intent = Intent(this, AudioActivity::class.java)
        startActivity(intent)
    }

    fun click_video_btn(view: View) {
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent)
    }
}