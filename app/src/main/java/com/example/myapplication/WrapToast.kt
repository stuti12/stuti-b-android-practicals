package com.example.myapplication

import android.app.Activity
import android.widget.TextView
import android.widget.Toast

fun Toast.showCustomToast(message: String, activity: Activity) {
    //  val layout = activity.layoutInflater.inflate(R.layout.customtoast)
    val layout = activity.layoutInflater.inflate(
        R.layout.customtoast,
        activity.findViewById(R.id.toast_container)
    )

    // set the text of the TextView of the message
    val textView: TextView = layout.findViewById(R.id.toast_text)
    textView.text = message

    // use the application extension function
    this.apply {
        // setGravity(Gravity.BOTTOM, 0, 40)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}
