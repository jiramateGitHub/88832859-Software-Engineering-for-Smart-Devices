package com.example.week4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class fragment_first : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_fragment_first, container, false)
        // Inflate the layout for this fragment

        val button : Button = view.findViewById(R.id.btnNextPage);

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment 2 Success",Toast.LENGTH_LONG).show()

            val fragment_second = fragment_second().newInstance("Love SE BY NEWGEN")

            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_second,"fragment_second")
            transaction.addToBackStack("fragment_second")
            transaction.commit()

        }

        return view;

    }
}
