package com.example.myapplication.RecycleViewPractical.RecycleView
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DataFile
import com.example.myapplication.R

class SpiritualTeacher(var name: String?, val quote: String, val image: Int) {
    var isSelected: Boolean = false
}

class RecycleViewActivity : AppCompatActivity() {
    val list : DataFile = DataFile()
    private val teachers: Array<SpiritualTeacher> = list.teachers

    private var sb: StringBuilder? = null
    internal lateinit var adapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        show()
    }

    private fun show() {
        adapter = RecycleAdapter(this, teachers)

        //RECYCLER
        val rv = findViewById<RecyclerView>(R.id.myRecycler)
        rv.layoutManager = LinearLayoutManager(this)
        rv.itemAnimator = DefaultItemAnimator()

        //SET ADAPTER
        rv.adapter = adapter
        val itemDecoration: RecyclerView.ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(itemDecoration)
    }
// end
}
