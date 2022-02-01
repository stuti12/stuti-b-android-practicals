package com.example.myapplication.RecycleViewPractical.ItemDecoration

import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(private var space: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = space
        outRect.right = space
    }

}