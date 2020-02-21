package com.example.a60160157_midterm


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class list_profile : Fragment() {
    private lateinit var recyclerView: RecyclerView
    var username : String = ""
    var password : String = ""

    fun newInstance(username : String,password : String): list_profile {

        val about_me = list_profile()
        val bundle = Bundle()
        bundle.putString("username", username)
        bundle.putString("password", password)
        about_me.setArguments(bundle)

        return about_me
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_profile, container, false)
        val jsonString : String = loadJsonFromAsset("team4.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("team4")
        recyclerView = view.findViewById(R.id.recyLayout)
        //ตั้งค่า Layout
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = layoutManager

        //ตั้งค่า Adapter
        val adapter = MyRecyclerAdapter(activity!!,jsonArray)
        recyclerView.adapter = adapter
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    private fun loadJsonFromAsset(filename: String, context: Context): String? {
        val json: String?

        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: java.io.IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }



}
