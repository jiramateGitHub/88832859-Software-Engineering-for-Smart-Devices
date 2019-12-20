package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.widget.TextView

class Main2Activity : AppCompatActivity() {
    private lateinit var username : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        username = findViewById<TextView>(R.id.textView2)

        val intent = getIntent()

        username.text = intent.getStringExtra("username")

    }
}
