package com.example.week3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class fragment_login : Fragment() {

    private var username : EditText ? = null
    private var password : EditText ? = null
    private var signin : Button ? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment

        username = view.findViewById<EditText>(R.id.editUsername)
        password = view.findViewById<EditText>(R.id.editPassword)
        signin = view.findViewById<Button>(R.id.signin)

        signin!!.setOnClickListener{
            Toast.makeText(context,"Welcome " + username!!.text.toString(),Toast.LENGTH_SHORT).show()
            val fragment_profile = fragment_profile().newInstance(username!!.text.toString(),password!!.text.toString())

            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_profile,"fragment_profile")
            transaction.addToBackStack("fragment_profile")
            transaction.commit()
        }
        return view;

    }
}
