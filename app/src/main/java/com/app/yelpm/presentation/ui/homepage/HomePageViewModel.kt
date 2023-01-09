package com.app.yelpm.presentation.ui.homepage

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.yelpm.domain.model.Business
import com.app.yelpm.repository.BusinessesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel
@Inject constructor(
    private val repository: BusinessesRepository
): ViewModel() {
    val businesses = mutableStateOf<List<Business>?>(listOf())
    private val _currentBusinesses: MutableLiveData<List<Business>?> = MutableLiveData(null)
    val currentBusiness: LiveData<List<Business>?> = _currentBusinesses
    fun search(location: String) {
        viewModelScope.launch {
            val response = repository.search(location)
            businesses.value = response
            _currentBusinesses.value = response
        }
    }
}