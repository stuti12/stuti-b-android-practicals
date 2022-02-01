package com.example.myapplication.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        showData()
    }
    private fun showData() {
        lateinit var spinner: Spinner
        lateinit var textView_cons: TextView
        title = "KotlinApp"
        textView_cons = findViewById(R.id.textView_cons)
        spinner = findViewById(R.id.sp_praise_cons)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.birds, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        btn_feedback_cons.setOnClickListener {
            Toast.makeText(this,"Feedback submitted",Toast.LENGTH_SHORT).show()
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        textView_cons.text = text
    }


}