package com.matheusdev.supermarkethelper.ui.fragment.categories

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusdev.supermarkethelper.R
import com.matheusdev.supermarkethelper.model.Category
import com.matheusdev.supermarkethelper.ui.activity.MainActivity
import com.matheusdev.supermarkethelper.ui.fragment.categories.adapter.CategoriesAdaprter
import com.matheusdev.supermarkethelper.ui.fragment.categorydetails.CategoryDetailsFragment


class CategoriesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).title = "Principal - Categorias"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val root = inflater.inflate(R.layout.fragment_categories, container, false)
        initializeViews(root)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(requireActivity())
            it.itemAnimator = DefaultItemAnimator()
            it.setHasFixedSize(true)
            it.adapter = CategoriesAdaprter(addCategories()) { categoryTitle ->
                arguments = Bundle().apply {
                    putString("category", categoryTitle)
                }
                val fragmentDetails = CategoryDetailsFragment()
                fragmentDetails.arguments = arguments
                (activity as MainActivity)
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_fragment, fragmentDetails)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun addCategories() = mutableListOf(
        Category(getString(R.string.txt_cleaning), R.drawable.ic_cleaning),
        Category(getString(R.string.txt_hygiene), R.drawable.ic_hygiene),
        Category(getString(R.string.txt_food), R.drawable.ic_food),
        Category(getString(R.string.txt_drink), R.drawable.ic_drink),
        Category(getString(R.string.txt_others), R.drawable.ic_others),
    )

    private fun initializeViews(root: View) {
        recyclerView = root.findViewById(R.id.recyclerView_categories)
    }
}