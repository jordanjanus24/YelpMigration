package com.app.yelpm.presentation.ui.homepage.bottomsheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
import com.app.yelpm.presentation.ui.homepage.businesslist.BusinessList
import com.app.yelpm.presentation.ui.homepage.businesslist.FilterOptions

@Composable
fun BottomSheet(homepageViewModel: HomePageViewModel) {
    Card(
        modifier = Modifier.fillMaxHeight(0.88f),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.surface) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                val businesses = homepageViewModel.businesses.value
                val sortedBusiness = homepageViewModel.sortedBusiness.value
                FilterOptions(
                    sortOptions = listOf("Distance","Ratings","Reviews"),
                    currentFilter = homepageViewModel.currentFilter
                ) {
                    if(homepageViewModel.currentFilter.value == it) {
                        homepageViewModel.sort("")
                    } else {
                        homepageViewModel.sort(it)
                    }
                }
                if(homepageViewModel.currentFilter.value == "") {
                    businesses?.let { it ->
                        BusinessList(businesses = it)
                    }
                } else {
                    sortedBusiness?.let { it ->
                        BusinessList(businesses = it)
                    }
                }

            }

        }
    }
}
