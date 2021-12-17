package com.jailseed.lab3

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class VideoPlayerActivity : AppCompatActivity() {
    lateinit var current_movie : String
    lateinit var list_movie : List<String>
    lateinit var videoPlayer: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val arguments = intent.extras
        current_movie = arguments?.getString("current_movie").toString()
        list_movie = arguments?.getStringArrayList("list_movie") as List<String>

        start_video(current_movie)
    }

    fun start_video (current_video : String) {
        if (current_video == "cat") {
            videoPlayer = findViewById<VideoView>(R.id.videoPlayer)
            val myVideoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.cat)
            videoPlayer.setVideoURI(myVideoUri)
        }
        else if (current_video == "false_alarm") {
            videoPlayer = findViewById<VideoView>(R.id.videoPlayer)
            val myVideoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.false_alarm)
            videoPlayer.setVideoURI(myVideoUri)
        }
        else if (current_video == "spiderman") {
            videoPlayer = findViewById<VideoView>(R.id.videoPlayer)
            val myVideoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.spiderman)
            videoPlayer.setVideoURI(myVideoUri)
        }

        val mediaController = MediaController(this)
        videoPlayer.setMediaController(mediaController)
        mediaController.setMediaPlayer(videoPlayer)
    }

    fun play(view: View?) {
        videoPlayer.start()
    }

    fun pause(view: View?) {
        videoPlayer.pause()
    }

    fun stop(view: View?) {
        videoPlayer.stopPlayback()
        videoPlayer.resume()
    }
}