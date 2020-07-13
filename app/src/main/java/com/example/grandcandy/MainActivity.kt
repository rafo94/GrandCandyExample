package com.example.grandcandy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grandcandy.adapter.CategoryAdapter
import com.example.grandcandy.adapter.ProductAdapter
import com.example.grandcandy.util.AnimationUtils
import com.example.grandcandy.util.DataUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryAdapter = CategoryAdapter(this, DataUtil.getCategoryData())
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        category_rv.layoutManager = layoutManager
        category_rv.adapter = categoryAdapter
        var lastScrollPosition = 0
        category_rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutScrolledManager = recyclerView.layoutManager as LinearLayoutManager?
                val lastPosition = layoutScrolledManager!!.findLastCompletelyVisibleItemPosition()
                val firstPosition = layoutScrolledManager.findFirstCompletelyVisibleItemPosition()
                for (i in firstPosition..lastPosition) {
                    val viewHolder = recyclerView.findViewHolderForAdapterPosition(i)
                    val viewHolderLast = recyclerView.findViewHolderForAdapterPosition(i - 1)
                    val viewHolderNext = recyclerView.findViewHolderForAdapterPosition(i + 1)
                    if (dx < 0) {
                        if (lastScrollPosition <= 30) {
                            val lastScrollPosition1 = lastScrollPosition++
                            viewHolder?.let {
                                AnimationUtils.animate(it, lastScrollPosition1)
                            }
                            viewHolderLast?.let {
                                AnimationUtils.animate(it,  lastScrollPosition1)
                            }
                            viewHolderNext?.let {
                                AnimationUtils.animate(it,  lastScrollPosition1)
                            }
                        }
                    } else {
                        if (lastScrollPosition >= -30) {
                            val lastPosition1 = lastScrollPosition--
                            viewHolder?.let {
                                AnimationUtils.animate(it,  lastPosition1)
                            }
                            viewHolderLast?.let {
                                AnimationUtils.animate(it,  lastPosition1)
                            }
                            viewHolderNext?.let {
                                AnimationUtils.animate(it,  lastPosition1)
                            }
                        }
                    }
                }
            }
        })
        val productAdapter = ProductAdapter(this, DataUtil.getProductData())
        val productLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        most_popular_rv.layoutManager = productLayoutManager
        most_popular_rv.adapter = productAdapter
    }
}