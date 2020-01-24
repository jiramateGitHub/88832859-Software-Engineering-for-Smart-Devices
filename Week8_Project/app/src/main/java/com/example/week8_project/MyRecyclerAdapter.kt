package com.example.week8_project

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week8_project.login.login
import com.example.week8_project.profile.detail
import org.json.JSONArray

class MyRecyclerAdapter(fragmentActivity: FragmentActivity, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

//    private val thiscontext : Context = context
    private val thiscontext : Context = fragmentActivity.baseContext
    private val thisActivity = fragmentActivity


    class Holder(view : View) : RecyclerView.ViewHolder(view) {
        private val View = view;

        lateinit var layout : LinearLayout
        lateinit var nameTextView: TextView
        lateinit var nameTextView2: TextView
        lateinit var detailTextView: TextView
        lateinit var titleTextView: TextView
        lateinit var image: ImageView
        lateinit var avatar: ImageView

        fun Holder(){

            layout = View.findViewById<View>(R.id.recyview_layout) as LinearLayout
            nameTextView = View.findViewById<View>(R.id.tv_name) as TextView
            nameTextView2 = View.findViewById<View>(R.id.tv_name2) as TextView
            titleTextView = View.findViewById<View>(R.id.tv_title) as TextView
            image = View.findViewById<View>(R.id.imgV) as ImageView
            avatar = View.findViewById<View>(R.id.avatar) as ImageView

        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recy_post_layout, parent, false))
    }


    override fun getItemCount(): Int {
        return dataSource.length()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.Holder()

        holder.nameTextView.setText( dataSource.getJSONObject(position).getString("name").toString() )
        holder.nameTextView2.setText( dataSource.getJSONObject(position).getString("name").toString() )
        holder.titleTextView.setText( dataSource.getJSONObject(position).getString("title").toString() )

        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("image").toString())
            .into(holder.image)

        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("avatar").toString())
            .into(holder.avatar)

        holder.layout.setOnClickListener {

            var nameTextView = dataSource.getJSONObject(position).getString("name").toString()
            var titleTextView = dataSource.getJSONObject(position).getString("title").toString()
            var detailTextView =
                dataSource.getJSONObject(position).getString("description").toString()
            var image = dataSource.getJSONObject(position).getString("image").toString()
            var avatar = dataSource.getJSONObject(position).getString("avatar").toString()

            val fragment_detail =
                detail().newInstance(nameTextView, titleTextView, detailTextView, image, avatar)

            val fm = thisActivity.supportFragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_detail, "fragment_detail")
            transaction.addToBackStack("fragment_detail")
            transaction.commit()
        }



    }





}

