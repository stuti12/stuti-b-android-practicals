package com.example.myapplication.RecycleViewPractical.ItemDecoration
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import java.util.ArrayList

class SpiritualTeachers(val image: Int) {
    var isSelected: Boolean = false
}

internal class GridAdapter(var c: Context, var teachers: Array<SpiritualTeachers>) : RecyclerView.Adapter<GridAdapter.MyHolder>() {
    var checkedTeachers = ArrayList<SpiritualTeachers>()

    //VIEWHOLDER IS INITIALIZED
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_grid_layout, null)
        return MyHolder(v)
    }

    //DATA IS BOUND TO VIEWS
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val teacher = teachers[position]
        holder.img.setImageResource(teacher.image)

        holder.setItemClickListener(object : MyHolder.ItemClickListener {
            override fun onItemClick(v: View, pos: Int) {
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
        lateinit var myItemClickListener: ItemClickListener

        init {
            img = itemView.findViewById(R.id.teacherImageView2)
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
