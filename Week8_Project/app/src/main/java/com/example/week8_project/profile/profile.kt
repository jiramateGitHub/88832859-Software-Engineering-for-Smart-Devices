package com.example.week8_project.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week8_project.CustomAdapter
import com.example.week8_project.MyRecyclerAdapter
import com.example.week8_project.R
import com.facebook.login.LoginManager
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class profile : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var listView: ListView
    var PhotoURL : String = ""
    var Name : String = ""
    var Email : String = ""

    fun newInstance(url: String,name : String,email : String): profile {

        val about_me = profile()
        val bundle = Bundle()
        bundle.putString("PhotoURL", url)
        bundle.putString("Name", name)
        bundle.putString("Email", email)
        about_me.setArguments(bundle)

        return about_me
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        val ivProfilePicture = view.findViewById(R.id.iv_profile) as ImageView
        val tvName = view.findViewById(R.id.tv_name) as TextView
        val tvEmail = view.findViewById(R.id.tv_email) as TextView
        val btn_logout = view.findViewById(R.id.login_button2) as Button

        Glide.with(activity!!.baseContext)
            .load(PhotoURL)
            .into(ivProfilePicture)

        tvName.setText(Name)
        tvEmail.setText(Email)

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        val jsonString : String = loadJsonFromAsset("recipes.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("recipes")
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        listView = view.findViewById(R.id.listview)
        val adapter =  CustomAdapter(activity!!.baseContext, jsonArray)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var nameTextView = jsonArray.getJSONObject(position).getString("name").toString()
            var titleTextView = jsonArray.getJSONObject(position).getString("title").toString()
            var detailTextView = jsonArray.getJSONObject(position).getString("description").toString()
            var image = jsonArray.getJSONObject(position).getString("image").toString()
            var avatar = jsonArray.getJSONObject(position).getString("avatar").toString()

            val fragment_detail = detail().newInstance(nameTextView,titleTextView,detailTextView,image,avatar)

            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_detail,"fragment_detail")
            transaction.addToBackStack("fragment_detail")
            transaction.commit()
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        recyclerView = view.findViewById(R.id.recyLayout)
//        //ตั้งค่า Layout
//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
//        recyclerView.layoutManager = layoutManager
//
//        //ตั้งค่า Adapter
//        val adapter = MyRecyclerAdapter(activity!!.baseContext,jsonArray)
//        recyclerView.adapter = adapter
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        btn_logout.setOnClickListener{
            LoginManager.getInstance().logOut()
            activity!!.supportFragmentManager.popBackStack()
        }


        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            PhotoURL = bundle.getString("PhotoURL").toString()
            Name = bundle.getString("Name").toString()
            Email = bundle.getString("Email").toString()

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

