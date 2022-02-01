package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var spinner: Spinner
        lateinit var textView: TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        title = "KotlinApp"
        textView = findViewById(R.id.textView)
        spinner = findViewById(R.id.sp_praise)
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
        textView.text = text
    }

}