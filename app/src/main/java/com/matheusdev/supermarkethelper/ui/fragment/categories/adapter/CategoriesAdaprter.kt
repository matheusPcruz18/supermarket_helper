package com.matheusdev.supermarkethelper.ui.fragment.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheusdev.supermarkethelper.R
import com.matheusdev.supermarkethelper.databinding.CardviewItemCategoryBinding
import com.matheusdev.supermarkethelper.model.Category

class CategoriesAdaprter(
    val categories: MutableList<Category>,
    val onClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriesAdaprter.CategoriesViewHolder>() {


    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewItemCategoryBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoriesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cardview_item_category, parent, false)
    )

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]

        with(holder) {
            binding.cardviewTitle.text = category.titleCategory
            binding.cardviewImage.setImageResource(category.imageCategory)

            binding.cardview.setOnClickListener {
                onClick(category.titleCategory)
            }
        }
    }

    override fun getItemCount() = categories.size
}