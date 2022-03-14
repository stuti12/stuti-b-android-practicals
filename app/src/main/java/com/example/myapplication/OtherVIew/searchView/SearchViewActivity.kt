package com.example.myapplication.com.example.myapplication.OtherVIew.SearchView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import com.example.myapplication.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_view.recyclerView
import kotlinx.android.synthetic.main.activity_search_view.searchView
import java.util.Locale

class SearchViewActivity : AppCompatActivity() {
    var adapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)
        title = "RecyclerView"

        setRecycleView()
    }

    private fun getCountries(): MutableList<Model> {
        val mdList = mutableListOf<Model>()
        for (countryISO in Locale.getISOCountries()) {
            val locale = Locale("", countryISO)
            if (!locale.displayCountry.isEmpty()) {
                mdList.add(Model(locale.displayCountry + "  " + counrtyFlag(countryISO)))
            }
        }
        return mdList
    }

    private fun counrtyFlag(countryCode: String): String {
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag =
            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))

        return flag
    }

    private fun showToast(msg: String) {
        Toast.makeText(this@SearchViewActivity, msg, Toast.LENGTH_SHORT).show()
    }

    private fun setRecycleView() {
        adapter = CustomAdapter(getCountries(), this)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter;

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                Log.d("onQueryTextChange", "query: " + query)
                adapter?.filter?.filter(query)
                return true
            }
        })

    }
}