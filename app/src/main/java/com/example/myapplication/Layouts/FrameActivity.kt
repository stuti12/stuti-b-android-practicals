package com.example.myapplication.Layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner : Spinner
    lateinit var textView_frm : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)
       showSpinner()
    }

    private fun showSpinner() {
        title = "KotlinApp"
        textView_frm = findViewById(R.id.textView_frm)
        spinner = findViewById(R.id.sp_praise_frame)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.birds,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        btn_feedback_frame.setOnClickListener {
            Toast.makeText(this,"Feedback",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        textView_frm.text = text
    }


}