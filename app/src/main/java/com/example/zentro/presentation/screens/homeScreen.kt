package com.example.zentro.presentation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.zentro.R
import com.example.zentro.dataModal.CardDataModel
import com.example.zentro.navigation.Routes
import com.example.zentro.presentation.BottomNav
import com.example.zentro.presentation.itemsDesign.CardItemDesign

import com.example.zentro.presentation.itemsDesign.CategoryDataModal
import com.example.zentro.presentation.itemsDesign.CategoryItem
import com.example.zentro.viewModal.CardViewModal
import kotlinx.coroutines.delay
import kotlinx.coroutines.time.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(
    navHostController: NavHostController, viewModal: CardViewModal = viewModel()
) {
    val categoryData = listOf(
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),
        CategoryDataModal(R.drawable.zlogo),

        )
    val cardDataItem = listOf(
        CardDataModel(1, R.drawable.cabbege, "Cabbage", "by weight 500g", "RS.50"),
        CardDataModel(2, R.drawable.banana, "Banana", "by pics 12p", "RS.40"),
        CardDataModel(3, R.drawable.tamato, "Banana", "by pics 12p", "RS.40"),
        CardDataModel(4, R.drawable.pattato, "Banana", "by pics 12p", "RS.40"),
        CardDataModel(5, R.drawable.cabbege, "Banana", "by pics 12p", "RS.40"),
        CardDataModel(6, R.drawable.banana, "Banana", "by pics 12p", "RS.40"),
    )
    var isSearch by remember {
        mutableStateOf(false)
    }
    var search by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.padding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    colorResource(R.color.Button_color),
                )

            )
        }, bottomBar = {
            BottomNav(navHostController = navHostController, selectedItem = 0, onClick = { index ->
                when (index) {
                    0 -> {
                        navHostController.navigate(Routes.HomeScreen)
                    }

                    1 -> {
                        navHostController.navigate(Routes.FavScreen)
                    }

                    2 -> {
                        navHostController.navigate(Routes.CartScreen)
                    }

                    3 -> {
                        navHostController.navigate(Routes.ProfileScreen)
                    }
                }
            })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues = it)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = search, onValueChange = { search = it },
                placeholder = { Text("Searching", fontSize = 15.sp) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                trailingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }, singleLine = true
            )
            Spacer(modifier = Modifier.height(15.dp))
           Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
               AutoSlider()
           }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "Category",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black, modifier = Modifier.padding(start = 5.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                LazyRow {
                    items(categoryData) {
                        CategoryItem(categoryDataModal = it)

                    }

                }
            }
            LazyColumn {
                items(cardDataItem.chunked(2)) { rowItem ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CardItemDesign(
                            cardDataModel = rowItem[0],
                            onAddClick = { viewModal.addToCart(it) },
                            onFavClick = { viewModal.addToFav(it) })

                        if (rowItem.size > 1) {
                            CardItemDesign(
                                cardDataModel = rowItem[1],
                                onAddClick = { viewModal.addToCart(it) },
                                onFavClick = { viewModal.addToFav(it) }
                            )
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }

            }


        }

    }


}

//basically it used to slide images
@Composable
fun AutoSlider() {
    val slideImages = listOf(
        R.drawable.pattato,
        R.drawable.tamato,
        R.drawable.cabbege,
        R.drawable.pattato
    )
    var currentIndex by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % slideImages.size
        }
    }
    Card(
        modifier = Modifier.size(width = 330.dp, height = 150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Image(
            painter = painterResource(id = slideImages[currentIndex]),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

    }

}
