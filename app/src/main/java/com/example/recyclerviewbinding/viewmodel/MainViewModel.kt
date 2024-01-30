package com.example.recyclerviewbinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewbinding.R
import com.example.recyclerviewbinding.model.MainDataModel
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val onButtonClicked = MutableLiveData<Boolean>()
    fun getData(){
        viewModelScope.launch {
            onButtonClicked.value = true
        }
    }

    val dataList = listOf(
        MainDataModel(1, "aadar", "daraye", R.drawable.ic_person),
        MainDataModel(2, "shassan", "daraye", R.drawable.ic_person),
        MainDataModel(3, "kbhat", "daraye",  R.drawable.ic_person)
    )
}