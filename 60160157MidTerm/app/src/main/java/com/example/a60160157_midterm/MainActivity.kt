package com.example.a60160157_midterm

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment_login = login()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.contentContainer, fragment_login,"fragment_login")
        transaction.addToBackStack("fragment_login")
        transaction.commit()
    }

    override fun onBackPressed() {
        val manager = supportFragmentManager.findFragmentById(R.id.contentContainer)
        if (manager is login ) {
            finish()
        } else {
            super.onBackPressed();
        }
    }

}
