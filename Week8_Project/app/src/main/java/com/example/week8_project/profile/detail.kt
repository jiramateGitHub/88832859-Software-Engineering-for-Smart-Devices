package com.example.week8_project.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.week8_project.R

/**
 * A simple [Fragment] subclass.
 */
class detail : Fragment() {

    private var nameTextView : String? = null
    private var titleTextView : String? = null
    private var detailTextView : String? = null
    private var image : String? = null
    private var avatar : String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)

        var layout_nameTextView : TextView = view.findViewById<TextView>(R.id.nameTextView)
        var layout_titleTextView : TextView = view.findViewById<TextView>(R.id.titleTextView)
        var layout_detailTextView : TextView = view.findViewById<TextView>(R.id.detailTextView)
        var layout_image : ImageView = view.findViewById<ImageView>(R.id.imageView)
        var layout_avatar : ImageView = view.findViewById<ImageView>(R.id.avatarView)
        layout_nameTextView.setText(nameTextView)
        layout_titleTextView.setText(titleTextView)
        layout_detailTextView.setText(detailTextView)
        Glide.with(this)
            .load(image)
            .into(layout_image);
        Glide.with(this)
            .load(avatar)
            .into(layout_avatar);

        return view
    }

    fun newInstance(name: String,title: String,detail:String,image:String,avatar:String): detail {
        val fragment = detail()
        val bundle = Bundle()
        bundle.putString("nameTextView", name)
        bundle.putString("titleTextView", title)
        bundle.putString("detailTextView", detail)
        bundle.putString("image", image)
        bundle.putString("avatar", avatar)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            nameTextView = bundle.getString("nameTextView").toString()
            titleTextView = bundle.getString("titleTextView").toString()
            detailTextView = bundle.getString("detailTextView").toString()
            image = bundle.getString("image").toString()
            avatar = bundle.getString("avatar").toString()

        }
    }

}
