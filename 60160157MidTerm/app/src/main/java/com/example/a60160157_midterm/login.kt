package com.example.a60160157_midterm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class login : Fragment() {
    private var username : EditText ? = null
    private var password : EditText ? = null
    private var signin : Button ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById<EditText>(R.id.editUsername)
        password = view.findViewById<EditText>(R.id.editPassword)
        signin = view.findViewById<Button>(R.id.signin)

        signin!!.setOnClickListener{
            var check_user = view.findViewById<EditText>(R.id.editUsername)!!.text.toString();
            var check_pass = view.findViewById<EditText>(R.id.editPassword)!!.text.toString();
            if(check_user == "" && check_pass == ""){
                Toast.makeText(context,"Please Enter You Username or Password", Toast.LENGTH_SHORT).show()
            }else if(check_user == ""  ){
                Toast.makeText(context,"Please Enter Your Username", Toast.LENGTH_SHORT).show()
            }else if(check_pass == ""){
                Toast.makeText(context,"Please Enter Your Password", Toast.LENGTH_SHORT).show()
            }else if( check_user == "60160157") {
                if (check_pass == "60160157") {
                    Toast.makeText(
                        context,
                        "Hello " + username!!.text.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    val fm = fragmentManager
                    val transaction: FragmentTransaction = fm!!.beginTransaction()

                    val fragment_profile = list_profile().newInstance(
                        username!!.text.toString(),
                        username!!.text.toString()
                    )
                    transaction.replace(R.id.contentContainer, fragment_profile, "list_profile")
                    transaction.addToBackStack("list_profile")
                    transaction.commit()
                } else {
                    Toast.makeText(
                        context,
                        "Please Check You Username or Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            
        }

        return view;
    }


}
