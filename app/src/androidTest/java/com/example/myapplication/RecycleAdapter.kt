package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


internal class MyAdapter(var c: Context, var teachers: Array<SpiritualTeacher>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var checkedTeachers = ArrayList<SpiritualTeacher>()

    //VIEWHOLDER IS INITIALIZED
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.model_recycleview, null)
        return MyHolder(v)
    }

    //DATA IS BOUND TO VIEWS
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val teacher = teachers[position]
        holder.nameTxt.text = teacher.name
        holder.posTxt.text = teacher.quote
        holder.myCheckBox.isChecked = teacher.isSelected
        holder.img.setImageResource(teacher.image)

        holder.myCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if(holder.myCheckBox.isChecked) {
                Toast.makeText(holder.myCheckBox.context, holder.nameTxt.text, Toast.LENGTH_SHORT)
                    .show()
            }
        }
        holder.setItemClickListener(object : MyHolder.ItemClickListener {
            override fun onItemClick(v: View, pos: Int) {
                val pos : Int = holder.adapterPosition
                val myCheckBox = v as CheckBox
                val currentTeacher = teachers[pos]
                if (myCheckBox.isChecked) {
                    currentTeacher.isSelected = true
                    checkedTeachers.add(currentTeacher)
                } else if (!myCheckBox.isChecked) {
                    currentTeacher.isSelected = false
                    checkedTeachers.remove(currentTeacher)
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return teachers.size
    }

    internal class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var img: ImageView
        var nameTxt: TextView
        var posTxt: TextView
        var myCheckBox: CheckBox

        lateinit var myItemClickListener: ItemClickListener

        init {
            nameTxt = itemView.findViewById(R.id.nameTextView)
            posTxt = itemView.findViewById(R.id.descritionTextView)
            img = itemView.findViewById(R.id.teacherImageView)
            myCheckBox = itemView.findViewById(R.id.myCheckBox)

            myCheckBox.setOnClickListener(this)
        }

        fun setItemClickListener(ic: ItemClickListener) {
            this.myItemClickListener = ic
        }

        override fun onClick(v: View) {
            this.myItemClickListener.onItemClick(v, layoutPosition)
        }

        internal interface ItemClickListener {

            fun onItemClick(v: View, pos: Int)
        }
    }
}
