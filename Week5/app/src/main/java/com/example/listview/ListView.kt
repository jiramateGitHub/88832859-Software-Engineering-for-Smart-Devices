package com.example.listview

package layout

private lateinit var listView: ListView

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_list_view, container, false)

    listView = view.findViewById(R.id.listview)

    val jsonString : String = loadJsonFromAsset("recipes.json", activity!!.baseContext).toString()
    val json = JSONObject(jsonString)
    val jsonArray = json.getJSONArray("recipes")

    val adapter = CustomAdapter(activity!!.baseContext, jsonArray)
    listView.adapter = adapter

    return view
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


