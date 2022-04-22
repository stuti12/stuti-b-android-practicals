package com.example.myapplication.Layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_feedback.*
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner2: Spinner
    lateinit var textView_tbl: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        showSpinner()
    }

    private fun showSpinner() {
        title = "KotlinApp"
        spinner2 = findViewById(R.id.sp_praise_tbl)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.birds,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter
        spinner2.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        textView_tbl.text = text
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this@TableActivity,"Nothing selected",Toast.LENGTH_SHORT).show()
    }

}
