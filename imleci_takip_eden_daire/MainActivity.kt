package com.example.simplegame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton.setOnClickListener{               //play e basınca bunlar olsun
            val intent=Intent(this,GameActivity::class.java)        /*intent activity'ler arası geçiş için.*/
            startActivity(intent)
        }
    }
}
