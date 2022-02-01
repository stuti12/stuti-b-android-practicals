package com.example.myapplication.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        show()
    }

    private fun show() {
        lateinit var spinner: Spinner
        lateinit var textView_tbl: TextView

        title = "KotlinApp"
        spinner = findViewById(R.id.sp_praise_tbl)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.birds,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        textView_tbl.text = text
    }
}