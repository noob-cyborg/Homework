package com.example.homework.moviedetails

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State

class ActorsListDecorator(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {

        with(outRect)
        {
            if (parent.getChildAdapterPosition(view) != 0) {
                left = margin
            }
        }
    }
}