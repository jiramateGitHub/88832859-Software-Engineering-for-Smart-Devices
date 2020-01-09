package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentLogin = fragment_login()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction();
        transaction.replace(R.id.contentContainer, fragmentLogin,"fragment_login");
        transaction.addToBackStack("fragment_login");
        transaction.commit();

    }

    override fun onBackPressed() {
        val manager = supportFragmentManager.findFragmentById(R.id.contentContainer)
        if (manager is fragment_login ) {
            finish()
        } else {
            super.onBackPressed();
        }
    }
}
