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
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week8_project.login.login
import com.example.week8_project.profile.detail
import org.json.JSONArray

class MyRecyclerAdapter(context: Context, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val thiscontext : Context = context

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

//        holder.layout.setOnClickListener{
//
//            Toast.makeText(thiscontext,holder.nameTextView.text.toString(),Toast.LENGTH_SHORT).show()
//
//        }

    }





}

