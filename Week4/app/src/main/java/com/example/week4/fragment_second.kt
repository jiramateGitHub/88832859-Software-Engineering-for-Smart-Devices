package com.example.week4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class fragment_second : Fragment() {
    private var msg : String = ""

    fun newInstance(message: String): fragment_second {

        val fragment = fragment_second()
        val bundle = Bundle()
        bundle.putString("msg", message)
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fragment_second, container, false)
        // Inflate the layout for this fragment

        val button : Button = view.findViewById(R.id.btnNextPage);

        val text : TextView = view.findViewById(R.id.Text)
        text.setText(msg)

        button.setOnClickListener {

            Toast.makeText(context,"Change to fragment 3 Success", Toast.LENGTH_LONG).show()

            val fragment_third = fragment_third()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_third,"fragment_third")
            transaction.addToBackStack("fragment_third")
            transaction.commit()

        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            msg = bundle.getString("msg").toString()

        }
    }

}
