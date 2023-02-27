package com.matheusdev.supermarkethelper.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheusdev.supermarkethelper.R
import com.matheusdev.supermarkethelper.ui.fragment.categories.CategoriesFragment

class MainActivity : AppCompatActivity() {
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        manager.beginTransaction().add(R.id.container_fragment, CategoriesFragment()).commit()
    }
}