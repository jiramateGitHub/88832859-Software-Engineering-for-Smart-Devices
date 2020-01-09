package com.example.listview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class fragment_list_view_detail : Fragment() {
    private var titleTextView : String? = null
    private var detailTextView : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_list_view_detail, container, false)
    }

    fun newInstance(title: String,detail: String): fragment_list_view_detail {
        val fragment = fragment_list_view_detail()
        val bundle = Bundle()
        bundle.putString("titleTextView", title)
        bundle.putString("detailTextView", detail)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            titleTextView = bundle.getString("titleTextView").toString()
            detailTextView = bundle.getString("detailTextView").toString()

        }
    }

}
