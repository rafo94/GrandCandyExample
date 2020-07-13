package com.example.grandcandy.util

import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.grandcandy.adapter.CategoryAdapter

class AnimationUtils {
    companion object {
        fun animate(viewHolder: ViewHolder, lastPosition: Int) {
            viewHolder as CategoryAdapter.CategoryHolder
            val rotate = RotateAnimation(
                lastPosition.toFloat(),
                lastPosition.toFloat(),
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            rotate.duration = 2500

            rotate.fillAfter = true
            viewHolder.categoryImage.startAnimation(rotate)
        }
    }
}