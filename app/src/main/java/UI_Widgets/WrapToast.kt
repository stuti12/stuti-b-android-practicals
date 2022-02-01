package com.example.myapplication

import android.app.Activity
import android.widget.TextView
import android.widget.Toast

fun Toast.showCustomToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate(
        R.layout.customtoast,
        activity.findViewById(R.id.toast_container)
    )

    val textView: TextView = layout.findViewById(R.id.toast_text)
    textView.text = message

    this.apply {
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}
