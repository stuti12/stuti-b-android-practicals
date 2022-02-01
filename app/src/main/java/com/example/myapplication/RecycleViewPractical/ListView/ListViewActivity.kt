package com.example.myapplication.RecycleViewPractical.ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.myapplication.DataFile
import com.example.myapplication.R

class ListViewActivity : AppCompatActivity() {
    val listData : DataFile = DataFile()
    private val language = listData.language
    private val description = listData.description

    private val imageId = listData.imageId
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listDisplay()
    }
    private fun listDisplay() {
        val myListAdapter = MyListAdapter(this,language,description,imageId)
        val listView : ListView = findViewById(R.id.listView)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
    }
}