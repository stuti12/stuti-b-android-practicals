package com.example.myapplication.RecycleViewPractical.ListView

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*

import android.widget.TextView
import android.view.LayoutInflater
import com.example.myapplication.R


class MyListAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.list_item, title) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       // val inflater = context.layoutInflater
       // val rowView = inflater.inflate(R.layout.list_item, null, true)
        var viewHolder = ViewHolder()
        val inflater = LayoutInflater.from(getContext())
        var convertView = inflater.inflate(R.layout.list_item, null, true)
        val titleText = convertView?.findViewById(R.id.title) as TextView
        val imageView = convertView?.findViewById(R.id.icon) as ImageView
        val subtitleText = convertView?.findViewById(R.id.description) as TextView

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])
        subtitleText.text = description[position]
        convertView.setTag(viewHolder);
        return convertView
    }
    private class ViewHolder {
        var title: TextView? = null
        var img : ImageView ? = null
        var subtitle: TextView? = null
    }
}
