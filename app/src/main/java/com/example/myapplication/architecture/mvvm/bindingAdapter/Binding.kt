package com.example.myapplication.architecture

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

@BindingAdapter("personImage")
fun setImage(view: ImageView, userImage: Int) {
    view.setImageResource(userImage)
}

@BindingAdapter("setText")
fun TextView.setText(value: String) {
    this.text = "String $value"
}

@InverseBindingAdapter(attribute = "setText")
fun TextView.getCustomText(): String {
    return this.text.toString()
}



