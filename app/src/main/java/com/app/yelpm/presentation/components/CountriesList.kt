package com.app.yelpm.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import com.app.yelpm.R
import com.app.yelpm.constants.Country
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
import com.app.yelpm.presentation.ui.homepage.HomePageViewType
import com.app.yelpm.utils.loadPicture
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountriesList(countries: List<Country>, homepageViewModel: HomePageViewModel, bottomSheetState: BottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier.fillMaxHeight(0.88f),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.surface) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Spacer(modifier = Modifier.requiredHeight(20.dp))
                LazyColumn {
                    items(countries) { country ->
                        Row(modifier = Modifier.fillMaxWidth().clickable {
                            coroutineScope.launch {
                                homepageViewModel.search(country.name)
                                bottomSheetState.collapse()
                                homepageViewModel.changeView(HomePageViewType.HOMEPAGE)
                            }
                        }) {
                            Row(modifier = Modifier.padding(all = 10.dp)) {
                                val image = loadPicture(
                                    url = "https://countryflagsapi.com/png/${country.code}",
                                    defaultImage = R.drawable.ic_baseline_map_24
                                ).value
                                CircularImageView(image)
                                Column(verticalArrangement = Arrangement.SpaceBetween) {
                                    Text(country.name, modifier = Modifier.fillMaxSize().padding(15.dp), style = MaterialTheme.typography.h6)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
