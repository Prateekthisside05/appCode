package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = NewsAdapter(this) // Initialize the mAdapter property here
        recyclerView.adapter = mAdapter // Set the initialized mAdapter as the adapter for RecyclerView
        fetchData()
    }

    private fun fetchData() {
        // Your fetch data logic using Volley goes here
        // Make sure to update the news data using mAdapter.updateNews(newsArray)
    }

    override fun onitemclicked(item: News) {
        // Handle item click event
    }
}
