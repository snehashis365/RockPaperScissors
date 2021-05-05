package com.snehashis.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playOnline.setOnClickListener {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show()
        }

        playOffline.setOnClickListener {
            val singleplayer = Intent(this, SinglePlayer::class.java)
            startActivity(singleplayer)
        }
    }
}