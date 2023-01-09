package com.app.yelpm.presentation.ui.homepage.businesslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.yelpm.R
import com.app.yelpm.domain.model.Business
import com.app.yelpm.presentation.components.RatingBar
import com.app.yelpm.presentation.components.RoundedCornerImageView
import com.app.yelpm.utils.loadPicture

@Composable
fun BusinessItem(business: Business) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(100.dp)
            .padding(
                start = 10.dp,
                top = 5.dp,
                end = 20.dp,
                bottom = 5.dp
            )
            .clickable {  }
    ) {
        Box(modifier = Modifier
            .padding(end = 8.dp)
            .requiredSize(70.dp)) {
            val image = business.imageUrl?.let { url ->
                loadPicture(
                    url = url,
                    defaultImage = R.drawable.ic_baseline_business_24
                ).value
            }
            image?.let { response ->
                response.bitmap?.let { img ->
                    RoundedCornerImageView(img = img, padding = if(response.success) 0.dp else 8.dp)
                }
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Row {
                business.name?.let { Text(it, style = MaterialTheme.typography.subtitle2) }
                Spacer(Modifier.weight(1f))
                business.distance?.let { distance ->
                    val kmDistance = distance * 0.0001
                    val kms = String.format("%.1f", kmDistance)
                    Text("${kms}km", style = MaterialTheme.typography.overline, color = Color.LightGray)
                }

                Spacer(modifier = Modifier.width(5.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                business.rating?.let { RatingBar(rating = it) }
                Spacer(Modifier.requiredWidth(10.dp))
                business.rating?.let { Text("$it Reviews", style = MaterialTheme.typography.overline, color = Color.LightGray) }
            }
            Text(business.getCategories(), style = MaterialTheme.typography.caption, color = Color.Black)
            business.location?.let { location ->
                Text(location.getDisplayAddress(), style = MaterialTheme.typography.overline, color = Color.LightGray)
            }
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
}