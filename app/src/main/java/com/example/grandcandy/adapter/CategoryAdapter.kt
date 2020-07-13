package com.example.grandcandy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.grandcandy.R
import com.example.grandcandy.model.Category
import de.hdodenhof.circleimageview.CircleImageView

class CategoryAdapter(private val context: Context, private var categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category_view, parent, false)
        return CategoryHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = categoryList[position]
        holder.initData(category)
    }

    inner class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryContainer: ConstraintLayout =
            view.findViewById(R.id.category_container_one)
        private val categoryTitle: TextView = view.findViewById(R.id.category_title_tv)
        private val categoryCount: TextView = view.findViewById(R.id.category_prod_count_tv)
        val categoryImage: CircleImageView = view.findViewById(R.id.category_image)

        fun initData(category: Category) {
            categoryContainer.background =
                ContextCompat.getDrawable(context, category.gradientColorId)
            categoryTitle.text = category.title
            categoryCount.text = category.count
            categoryImage.setImageResource(category.catImageId)
        }
    }
}