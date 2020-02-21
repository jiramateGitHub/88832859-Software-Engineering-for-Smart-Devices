package com.example.a60160157_midterm

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
import org.json.JSONArray

class MyRecyclerAdapter(fragmentActivity: FragmentActivity, val dataSource: JSONArray) : RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    //    private val thiscontext : Context = context
    private val thiscontext : Context = fragmentActivity.baseContext
    private val thisActivity = fragmentActivity


    class Holder(view : View) : RecyclerView.ViewHolder(view) {
        private val View = view;

        lateinit var layout : LinearLayout
        lateinit var firstname: TextView
        lateinit var lastname: TextView
        lateinit var position: TextView
        lateinit var html: TextView
        lateinit var css: TextView
        lateinit var php: TextView
        lateinit var javascript: TextView
        lateinit var sql: TextView
        lateinit var image: ImageView

        fun Holder(){

            layout = View.findViewById<View>(R.id.recyview_layout) as LinearLayout
            firstname = View.findViewById<View>(R.id.layout_firstname) as TextView
//            lastname = View.findViewById<View>(R.id.layout_lastname) as TextView
            position = View.findViewById<View>(R.id.layout_position) as TextView
//            html = View.findViewById<View>(R.id.layout_html) as TextView
//            css = View.findViewById<View>(R.id.layout_css) as TextView
//            php = View.findViewById<View>(R.id.layout_php) as TextView
//            javascript = View.findViewById<View>(R.id.layout_javascript) as TextView
//            sql = View.findViewById<View>(R.id.layout_sql) as TextView
            image = View.findViewById<View>(R.id.layout_image) as ImageView

        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recy_list, parent, false))
    }


    override fun getItemCount(): Int {
        return dataSource.length()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.Holder()

        holder.firstname.setText( dataSource.getJSONObject(position).getString("firstname").toString()+ " " + dataSource.getJSONObject(position).getString("lastname").toString() )
        holder.position.setText( dataSource.getJSONObject(position).getString("position").toString() )

        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("image").toString())
            .into(holder.image)

        holder.layout.setOnClickListener {

            var firstname = dataSource.getJSONObject(position).getString("firstname").toString()
            var lastname = dataSource.getJSONObject(position).getString("lastname").toString()
            var position_2 = dataSource.getJSONObject(position).getString("position").toString()
            var html = dataSource.getJSONObject(position).getString("html").toString()
            var css = dataSource.getJSONObject(position).getString("css").toString()
            var php = dataSource.getJSONObject(position).getString("php").toString()
            var javascript = dataSource.getJSONObject(position).getString("javascript").toString()
            var sql = dataSource.getJSONObject(position).getString("sql").toString()
            var image = dataSource.getJSONObject(position).getString("image").toString()

            val fragment_detail =
                detail().newInstance(firstname, lastname, position_2, image, html,css,php,javascript,sql)

            val fm = thisActivity.supportFragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_detail, "fragment_detail")
            transaction.addToBackStack("fragment_detail")
            transaction.commit()
        }



    }





}

