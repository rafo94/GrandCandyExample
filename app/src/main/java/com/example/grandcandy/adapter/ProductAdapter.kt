package com.example.grandcandy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grandcandy.R
import com.example.grandcandy.model.Product
import com.example.grandcandy.view.HorizontalNumberPicker

class ProductAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_most_popular_view, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = productList[position]
        holder.initData(product)
    }

    inner class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val productName: TextView = view.findViewById(R.id.product_name_tv)
        private val productPrice: TextView = view.findViewById(R.id.price_tv)
        private val productImage: ImageView = view.findViewById(R.id.product_iv)
        private val marketContainer: ImageView = view.findViewById(R.id.market_iv)
        private val numberPicker: HorizontalNumberPicker = view.findViewById(R.id.number_picker)

        @SuppressLint("SetTextI18n")
        fun initData(product: Product) {
            productName.text = product.name
            productPrice.text = "${product.price} ${product.rate}/${product.weight}"
            productImage.setImageResource(product.productImageId)

            numberPicker.max = 999
            numberPicker.min = 0
            numberPicker.setListener(object : HorizontalNumberPicker.OnValueChangeListener {
                override fun changeValueData(value: Int) {
                    if (value == 0) {
                        numberPicker.visibility = View.GONE
                        marketContainer.visibility = View.VISIBLE
                    }
                }

            })

            marketContainer.setOnClickListener {
                numberPicker.visibility = View.VISIBLE
                marketContainer.visibility = View.GONE
            }
        }
    }
}