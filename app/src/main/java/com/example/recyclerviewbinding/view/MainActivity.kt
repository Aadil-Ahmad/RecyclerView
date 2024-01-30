package com.example.recyclerviewbinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewbinding.R
import com.example.recyclerviewbinding.adapter.MainAdapter
import com.example.recyclerviewbinding.databinding.ActivityMainBinding
import com.example.recyclerviewbinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : MainAdapter
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.onButtonClicked.observe(this){isClicked ->
            if (isClicked){
                Log.d("aadar", "BUTTON IS CLICKED")
                setAdapter()
            }
        }
    }

    private fun setAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(viewModel.dataList)
        binding.recyclerView.adapter = adapter
    }
}