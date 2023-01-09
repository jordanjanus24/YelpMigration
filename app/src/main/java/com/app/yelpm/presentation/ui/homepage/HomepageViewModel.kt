package com.app.yelpm.presentation.ui.homepage

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.yelpm.domain.model.Business
import com.app.yelpm.repository.BusinessesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel
@Inject constructor(
    private val repository: BusinessesRepository
): ViewModel() {
    val businesses: MutableState<List<Business>> = mutableStateOf(listOf())
    fun search(location: String) {
        viewModelScope.launch {
            businesses.value = repository.search(location)
            Log.d("BUSINESSES", businesses.value.toString())
        }
    }
}