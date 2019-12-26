package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment_first = fragment_first()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction();
        transaction.replace(R.id.contentContainer, fragment_first,"fragment_first");
        transaction.addToBackStack("fragment_first");
        transaction.commit();

    }

    override fun onBackPressed() {

        val manager = supportFragmentManager.findFragmentById(R.id.contentContainer)

        if (manager is fragment_first ) {

            finish()

        }
        else{
            super.onBackPressed();
        }

    }

}
