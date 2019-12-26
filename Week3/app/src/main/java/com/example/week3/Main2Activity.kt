package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.widget.TextView

class Main2Activity : AppCompatActivity() {
    private var username : TextView? = null
    private var password : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        username = findViewById<TextView>(R.id.editUsername)
        password = findViewById<TextView>(R.id.editPassword)

        val intent = intent

        username!!.text = intent.getStringExtra("username")
        password!!.text = intent.getStringExtra("password")

    }
}
