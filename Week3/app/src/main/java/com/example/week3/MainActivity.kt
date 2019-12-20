package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var username : EditText ? = null
    private var password : EditText ? = null
    private var login : Button ? = null
    private var signup : Button ? = null
    private var facebook : Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {

        }
        setInitView()
        login!!.setOnClickListener{
            Toast.makeText(applicationContext,username!!.text.toString(),Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("username",username.toString())
            startActivity(intent)
        }

    }


    private fun setInitView() {
        username = findViewById<EditText>(R.id.editUsername)
        password = findViewById<EditText>(R.id.editPassword)
        login = findViewById<Button>(R.id.btnLogin)
        signup = findViewById<Button>(R.id.btnSignup)
        facebook = findViewById<Button>(R.id.btnFb)
    }


}
