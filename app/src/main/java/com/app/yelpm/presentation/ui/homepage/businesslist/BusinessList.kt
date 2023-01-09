package com.app.yelpm.presentation.ui.homepage.businesslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.app.yelpm.domain.model.Business

@Composable
fun BusinessList(businesses: List<Business>) {
    Box {
        LazyColumn {
            items(businesses) { business ->
                BusinessItem(business = business)
            }
        }
    }
}