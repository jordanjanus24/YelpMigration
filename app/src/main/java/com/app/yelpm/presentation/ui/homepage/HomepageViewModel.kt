package com.app.yelpm.presentation.ui.homepage

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.yelpm.domain.model.Business
import com.app.yelpm.domain.model.Coordinates
import com.app.yelpm.network.model.BusinessDTOMapper
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel
import com.app.yelpm.repository.BusinessesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel
@Inject constructor(
    private val repository: BusinessesRepository,
    private val businessDTOMapper: BusinessDTOMapper
): ViewModel() {
    val businesses = mutableStateOf<List<Business>?>(listOf())
    private val _currentBusinesses: MutableLiveData<List<Business>?> = MutableLiveData(null)
    val currentBusiness: LiveData<List<Business>?> = _currentBusinesses
    private val _currentCenter: MutableLiveData<Coordinates?> = MutableLiveData(null)
    val currentCenter: LiveData<Coordinates?> = _currentCenter
    fun search(location: String) {
        viewModelScope.launch {
            val response = repository.search(location)
            val businessesResponse = businessDTOMapper.toDomainList(response.businesses!!)
            businesses.value = businessesResponse
            _currentBusinesses.value = businessesResponse
            val center = response.region?.center!!
            val coordinates = Coordinates(latitude = center.latitude, longitude = center.longitude)
            _currentCenter.value = coordinates
        }
    }
}