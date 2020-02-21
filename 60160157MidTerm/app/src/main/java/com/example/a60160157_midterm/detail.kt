package com.example.a60160157_midterm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class detail : Fragment() {
    private var firstname : String? = null
    private var lastname : String? = null
    private var position : String? = null
    private var html : String? = null
    private var css : String? = null
    private var php : String? = null
    private var javascript : String? = null
    private var sql : String? = null
    private var image : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        var layout_firstname : TextView = view.findViewById<TextView>(R.id.layout_name_detail)
        var layout_position : TextView = view.findViewById<TextView>(R.id.layout_postiton_detail)
        var layout_html : TextView = view.findViewById<TextView>(R.id.layout_html_detail)
        var layout_css : TextView = view.findViewById<TextView>(R.id.layout_css_detail)
        var layout_php : TextView = view.findViewById<TextView>(R.id.layout_php_detail)
        var layout_javascript : TextView = view.findViewById<TextView>(R.id.layout_javascript_detail)
        var layout_sql : TextView = view.findViewById<TextView>(R.id.layout_sql_detail)
        var layout_image : ImageView = view.findViewById<ImageView>(R.id.layout_image_detail)
        layout_firstname.setText(firstname + " " + lastname)
        layout_position.setText(position)
        layout_html.setText("HTML Language: "+ html)
        layout_css.setText("CSS Language: "+css)
        layout_php.setText("PHP Language: "+php)
        layout_javascript.setText("JAVASCRIPT Language: "+javascript)
        layout_sql.setText("SQL Language: "+sql)
        Glide.with(this)
            .load(image)
            .into(layout_image);

        return view;
    }


    fun newInstance(firstname: String,lastname:String,position:String,image:String,html:String,css:String,php:String,javascript:String,sql:String): detail {
        val fragment = detail()
        val bundle = Bundle()
        bundle.putString("firstname", firstname)
        bundle.putString("lastname", lastname)
        bundle.putString("image", image)
        bundle.putString("position", position)
        bundle.putString("html", html)
        bundle.putString("css", css)
        bundle.putString("php", php)
        bundle.putString("javascript", javascript)
        bundle.putString("sql", sql)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            firstname = bundle.getString("firstname").toString()
            lastname = bundle.getString("lastname").toString()
            image = bundle.getString("image").toString()
            position = bundle.getString("position").toString()
            html = bundle.getString("html").toString()
            css = bundle.getString("css").toString()
            php = bundle.getString("php").toString()
            javascript = bundle.getString("javascript").toString()
            sql = bundle.getString("sql").toString()

        }
    }



}
