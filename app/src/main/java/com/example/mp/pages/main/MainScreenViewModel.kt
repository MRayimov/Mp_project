package com.example.mp.pages.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainScreenViewModel : ViewModel() {

    private val _pageIndex = MutableStateFlow(0)
    val pageIndex: StateFlow<Int> = _pageIndex.asStateFlow()


    fun onPageIndexChange(index: Int) {
        _pageIndex.value = index
    }

}
