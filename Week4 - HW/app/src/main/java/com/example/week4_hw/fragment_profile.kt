package com.example.week4_hw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class fragment_profile : Fragment() {
    private var username : String? = null
    private var password : String? = null

    fun newInstance(username: String,password: String): fragment_profile {
        val fragment = fragment_profile()
        val bundle = Bundle()
        bundle.putString("username", username)
        bundle.putString("password", password)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        // Inflate the layout for this fragment

        var layout_username : TextView = view.findViewById<TextView>(R.id.editUsername)
        var layout_password : TextView = view.findViewById<TextView>(R.id.editPassword)
        layout_username.setText(username)
        layout_password.setText(password)

        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            username = bundle.getString("username").toString()
            password = bundle.getString("password").toString()

        }
    }


}
