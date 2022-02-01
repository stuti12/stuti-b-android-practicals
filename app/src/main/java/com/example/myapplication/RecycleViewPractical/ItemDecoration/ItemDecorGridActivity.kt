package com.example.myapplication.RecycleViewPractical.ItemDecoration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.myapplication.R

class ItemDecorGridActivity : AppCompatActivity() {

    private val teachers: Array<SpiritualTeachers>
        get() =
            arrayOf(
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image),
                SpiritualTeachers(R.drawable.c_image)
            )
    internal var sb: StringBuilder? = null
    private lateinit var adapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_decor_grid)
        setItemDecor()

    }

    private fun setItemDecor() {
        adapter = GridAdapter(this, teachers)

        //RECYCLER
        val itemDecorRecycleView = findViewById<RecyclerView>(R.id.myRecyclerView)
        val gridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        itemDecorRecycleView.layoutManager = gridLayoutManager
        //SET ADAPTER
        itemDecorRecycleView.adapter = adapter

        val itemDecoration: ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        itemDecorRecycleView.addItemDecoration(itemDecoration)
        var eq = SpacesItemDecoration(26)
        itemDecorRecycleView.addItemDecoration(eq);
    }
// end
}

