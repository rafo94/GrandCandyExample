package com.example.grandcandy.util

import com.example.grandcandy.R
import com.example.grandcandy.model.Category
import com.example.grandcandy.model.Product

class DataUtil {

    companion object {
        fun getCategoryData(): List<Category> {
            val categoryList = mutableListOf<Category>()
            val categoryCakes = Category(
                "Cakes",
                "75 products",
                R.drawable.category_item_one_background,
                R.drawable.category_one
            )
            categoryList.add(categoryCakes)

            val categoryChocolate = Category(
                "Chocolate",
                "75 products",
                R.drawable.category_item_two_background,
                R.drawable.category_two
            )
            categoryList.add(categoryChocolate)

            val categoryCookies = Category(
                "Cookies",
                "75 products",
                R.drawable.category_item_three_background,
                R.drawable.category_three
            )
            categoryList.add(categoryCookies)
            return categoryList
        }

        fun getProductData(): List<Product> {
            val productList = mutableListOf<Product>()
            val productBiscuits =
                Product("Biscuits with chocolate", 2500.0, "֏", "kg", R.drawable.prod_1)
            productList.add(productBiscuits)

            val productCandy =
                Product("Candy chocolate circles", 2500.0, "֏", "kg", R.drawable.prod_2)
            productList.add(productCandy)

            val productJelly = Product("Jelly Gummy", 2500.0, "֏", "kg", R.drawable.prod_3)
            productList.add(productJelly)

            val productMarmalade = Product("Marmalade", 2500.0, "֏", "kg", R.drawable.prod_4)
            productList.add(productMarmalade)

            val productChocolates =
                Product("Chocolates with variable fruits", 2500.0, "֏", "kg", R.drawable.prod_5)
            productList.add(productChocolates)

            return productList
        }
    }
}