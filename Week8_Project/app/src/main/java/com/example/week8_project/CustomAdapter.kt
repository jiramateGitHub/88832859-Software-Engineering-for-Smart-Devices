package com.example.week8_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import org.json.JSONArray

class CustomAdapter(context: Context, val dataSource: JSONArray) : BaseAdapter() {

    private val thiscontext: Context = context
    private val inflater: LayoutInflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.length()
    }

    override fun getItem(position: Int): Any {
        return dataSource.getJSONObject(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val holder : ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.recy_post_layout, parent, false)

            // 3
            holder = ViewHolder()

            holder.layout = view.findViewById(R.id.recyview_layout)
            holder.nameTextView = view.findViewById(R.id.tv_name) as TextView
            holder.nameTextView2 = view.findViewById(R.id.tv_name2) as TextView
            holder.titleTextView = view.findViewById(R.id.tv_title) as TextView
            holder.image = view.findViewById(R.id.imgV) as ImageView
            holder.avatar = view.findViewById(R.id.avatar) as ImageView
            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6

        holder.nameTextView.setText( dataSource.getJSONObject(position).getString("name").toString() )
        holder.nameTextView2.setText( dataSource.getJSONObject(position).getString("name").toString() )
        holder.titleTextView.setText( dataSource.getJSONObject(position).getString("title").toString() )

        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("image").toString())
            .into(holder.image)

        Glide.with(thiscontext)
            .load(dataSource.getJSONObject(position).getString("avatar").toString())
            .into(holder.avatar)

        return view
    }

    private class ViewHolder {
        lateinit var layout : LinearLayout
        lateinit var nameTextView: TextView
        lateinit var nameTextView2: TextView
        lateinit var detailTextView: TextView
        lateinit var titleTextView: TextView
        lateinit var image: ImageView
        lateinit var avatar: ImageView
    }

}
